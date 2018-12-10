package com.webshopback.aspect;/**
 * @Auther: zhou
 * @Date: 2018/11/9 14:51
 * @Description:
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 *@ClassName aspectConfig
 *@Description TODO
 *@Author zhou
 *Date 2018/11/9 14:51
 *@Version 1.0
 **/
@Aspect
@Component
public class WebLogAspect {

    private static final Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(public * com.webshopback.controller.*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("前置通知");
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        Enumeration<String> enums = request.getParameterNames();
        List<String> params = new ArrayList();
        while (enums.hasMoreElements()) {
            String paraName = enums.nextElement();
            String param = paraName + ":" + request.getParameter(paraName);
            params.add(param);
        }

        //url
        log.debug("URL: " + request.getRequestURL().toString());
        //method
        log.debug("METHOD: " + request.getMethod());
        //params
        log.debug("PARAMS: " + params.toString());
        //ip
        log.debug("IP: " + request.getRemoteAddr());
        //类方法
        log.debug("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());
        //参数
        //log.info("args={}", Arrays.toString(joinPoint.getArgs()));
    }

    @After("webLog()")
    public void doAfter(){
        System.out.println("后置通知");
    }

    @AfterReturning(pointcut = "webLog()",returning = "object")
    public void doAfterReturning(Object object) throws Throwable{
        log.debug("RESPONSE: " + object);
        log.debug("SPEND_TIME:"+ (System.currentTimeMillis() - startTime.get()) + "ms");
    }
}
