package com.aisino.log;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @Description: controller-aop日志打印
 * @author zhukaishengy
 * @date 2017年11月15日
 */

@Aspect
@Component
public class ControllerLogAspects {

    private final static Logger logger = Logger.getLogger(ControllerLogAspects.class);
    
    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.aisino.controller..*.*(..))")
    public void aspect(){}
    /** 
     * 前置通知，方法调用前被调用 
     * @param joinPoint 
     * @throws JsonProcessingException 
     */  
    @Before("aspect()")  
    public void doBeforeAdvice(JoinPoint joinPoint) throws JsonProcessingException{
        logger.info("====================一次请求开始=======================");
        //用的最多 通知的签名  
        Signature signature = joinPoint.getSignature();  
        //AOP代理类的名字  
        logger.info("controller处理类："+signature.getDeclaringTypeName());
        //代理的是哪一个方法  
        logger.info("执行方法名："+signature.getName());
        //获取RequestAttributes  
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
        //从获取RequestAttributes中获取HttpServletRequest的信息  
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);  
        //如果要获取Session信息的话，可以这样写：  
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);  
        Enumeration<String> enumeration = request.getParameterNames();  
        Map<String,String> parameterMap = new HashMap<String, String>();  
        while (enumeration.hasMoreElements()){  
            String parameter = enumeration.nextElement();  
            parameterMap.put(parameter,request.getParameter(parameter));  
        }
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(parameterMap);
        if(parameterMap.size() > 0) {  
            logger.info("请求的参数信息为："+str);
        }  
    }
    /** 
     * 后置返回通知 
     * 这里需要注意的是: 
     *      如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息 
     *      如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数 
     * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值 
     * @param joinPoint 
     * @param keys 
     */  
//    @AfterReturning(value ="aspect()",returning="")  
//    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object result){  
//    	logger.info("方法的返回值："+result);
//    } 
    /** 
     * 后置异常通知 
     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法； 
     *  throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行， 
     *      对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。 
     * @param joinPoint 
     * @param exception 
     */  
    @AfterThrowing(value = "aspect()",throwing = "exception")  
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){  
        //目标方法名：  
        System.out.println(joinPoint.getSignature().getName());
        logger.info(joinPoint.getSignature().getName()+"方法抛出异常!");
        exception.printStackTrace();
        logger.info("====================一次请求抛出异常=======================");
    }  
  
    /** 
     * 后置最终通知（目标方法只要执行完了就会执行后置通知方法） 
     * @param joinPoint 
     */  
    @After("aspect()")  
    public void doAfterAdvice(JoinPoint joinPoint){  
  
    	logger.info("====================一次请求结束=======================");
    }  
  
}
