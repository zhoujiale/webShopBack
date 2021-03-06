package com.webShopBack.shrio;/**
 * @Auther: zhou
 * @Date: 2018/10/19 11:55
 * @Description:
 */

import com.webShopBack.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *@ClassName PassWordHelper
 *@Description 加盐加密
 *@Author zhou
 *Date 2018/10/19 11:55
 *@Version 1.0
 **/
@Component
public class PassWordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("MD5")
    private String algorithmName;
    @Value("2")
    private int hashIterations;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public User encryptPassword(User user){
        if(user.getSalt() == null || "".equals(user.getSalt())){
            user.setSalt(randomNumberGenerator.nextBytes().toHex());
        }
        String newPassword = new SimpleHash(algorithmName,user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),hashIterations).toHex();
        user.setPassword(newPassword);
        return user;
    }

}
