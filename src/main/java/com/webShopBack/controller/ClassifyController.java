package com.webShopBack.controller;/**
 * @Auther: zhou
 * @Date: 2018/12/8 11:10
 * @Description:
 */

import com.webShopBack.response.WebResponse;
import com.webShopBack.service.ClassifyService;
import com.webShopBack.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName ClassifyController
 *@Description 主类目
 *@Author zhou
 *Date 2018/12/8 11:10
 *@Version 1.0
 **/
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    private static Logger log = Logger.getLogger(ClassifyController.class);

    @Autowired
    private ClassifyService classifyService;

    /**
     * @description 分页返回分类信息
     * @author zhou
     * @created  2018/12/11 12:04
     * @param pageNum 页号
     * @param pageSize 返回记录
     * @return
     */
    @RequestMapping(value = "/find",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse findClassify(@RequestParam(value = "pageNum",defaultValue = "1",required = true) int pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10",required = true) int pageSize){
         WebResponse webResponse = classifyService.findAllByClassify(pageNum,pageSize);
         return webResponse;
    }

    /**
     * @description 新增父类目
     * @author zhou
     * @created  2018/12/11 14:30
     * @param classifyName 父类目名称
     * @return
     */
    @RequestMapping(value = "/addclassify",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse addClassify(String classifyName){
        if(StringUtil.isEmpty(classifyName)){
            log.error("父类目为空");
            return new WebResponse().error(401,"","父类目为空");
        }
        WebResponse webResponse = classifyService.addClassify(classifyName);
        return webResponse;
    }

    /**
     * @description 增加子类目
     * @author zhou
     * @created  2018/12/26 15:04
     * @param subClassifyName 子类目
     * @param mainClassifyName 父类目
     * @return 
     */
    @RequestMapping(value = "/addSubClassify",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse addSubClassify(String subClassifyName,String mainClassifyName){
        if(StringUtil.isEmpty(subClassifyName)||StringUtil.isEmpty(mainClassifyName)){
            log.error("参数错误");
            return new WebResponse().error(400,"","参数错误");
        }
        WebResponse webResponse = classifyService.addSubClassify(subClassifyName,mainClassifyName);
        return webResponse;
    }
}
