package com.webShopBack.service.impl;/**
 * @Auther: zhou
 * @Date: 2018/12/11 12:00
 * @Description:
 */

import com.github.pagehelper.PageHelper;
import com.webShopBack.dao.ClassifyDao;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 *@ClassName ClassifyServiceImpl
 *@Description TODO
 *@Author zhou
 *Date 2018/12/11 12:00
 *@Version 1.0
 **/
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = {Exception.class})
public class ClassifyServiceImpl implements ClassifyService{

    @Autowired
    private ClassifyDao classifyDao;

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
        //查询所有的父类目
        List<HashMap<String,Object>> classifyList = classifyDao.findAllByClassify();
        //查询所有的子类目
        List<HashMap<String,Object>> subClassifyList = classifyDao.findAllBySubClassify();
        return null;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public WebResponse addClassify(String classifyName) {
        int count = classifyDao.findClassifyName();
        return null;
    }
}
