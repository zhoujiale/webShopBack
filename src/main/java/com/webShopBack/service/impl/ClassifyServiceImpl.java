package com.webShopBack.service.impl;/**
 * @Auther: zhou
 * @Date: 2018/12/11 12:00
 * @Description:
 */

import com.github.pagehelper.PageHelper;
import com.webShopBack.dao.ClassifyDao;
import com.webShopBack.dao.SubClassifyDao;
import com.webShopBack.entity.Classify;
import com.webShopBack.entity.SubClassify;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.ClassifyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;

/**
 *@ClassName ClassifyServiceImpl
 *@Description 类目接口类
 *@Author zhou
 *Date 2018/12/11 12:00
 *@Version 1.0
 **/
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = {Exception.class})
public class ClassifyServiceImpl implements ClassifyService{

    private static Logger log = Logger.getLogger(ClassifyServiceImpl.class);

    @Autowired
    private ClassifyDao classifyDao;
    @Autowired
    private SubClassifyDao subClassifyDao;

    /**
     * @description 返回分类
     * @author zhou
     * @created  2018/12/11 14:48    
     * @param 
     * @return 
     */
    @Override
    public WebResponse findAllByClassify(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HashMap<String,Object>> list = subClassifyDao.findAllClassify();
        if(list.size() ==0){
            log.error("类目为空");
            return new WebResponse().error(400,"","类目为空");
        }
        return new WebResponse().ok(list);
    }

    /**
     * @description 增加父分类
     * @author zhou
     * @created  2018/12/26 14:11    
     * @param 
     * @return 
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public WebResponse addClassify(String classifyName) {
        Classify classify = new Classify();
        classify.setClassifyName(classifyName);
        classify.setStatus(true);
        try {
            int count = classifyDao.addMainClassify(classify);
            if(count == 0){
                throw new RuntimeException();
            }
        }catch (Exception e){
            log.error("增加父分类失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(401,"","增加父分类失败");
        }
        return new WebResponse().ok("增加父分类成功");
    }

    /**
     * @description 新增子类目
     * @author zhou
     * @created  2018/12/26 15:29
     * @param subClassifyName
     * @param mainClassifyName
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public WebResponse addSubClassify(String subClassifyName, String mainClassifyName) {
        SubClassify subClassify = new SubClassify();
        subClassify.setMainClassifyId(classifyDao.findClassifyByMainName(mainClassifyName));
        subClassify.setStatus(true);
        subClassify.setSubClassifyName(subClassifyName);
        try {
            int addCount = subClassifyDao.addSubClassify(subClassify);
            if(addCount == 0){
                throw new RuntimeException();
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("增加子类目失败");
            return new WebResponse().error(401,"","增加子类目失败");
        }
        return new WebResponse().ok("增加子类目成功");
    }

    /**
     * @description 编辑类目
     * @author zhou
     * @created  2019/1/5 11:19
     * @param level
     * @param classifyId
     * @param classifyName
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public WebResponse editClassify(Integer level, Integer classifyId, String classifyName) {
        try {
            if (level == 0) {
                //为父类
                Integer count = classifyDao.updateClassify(classifyId, classifyName);

            } else if (level == 1) {
                //为子类
                Integer subCount = subClassifyDao.updateSubClassify(classifyId, classifyName);
            }
            return new WebResponse().ok("编辑成功");
        }catch (Exception e){
            log.error("编辑失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(401,"","编辑失败");
        }
    }
}
