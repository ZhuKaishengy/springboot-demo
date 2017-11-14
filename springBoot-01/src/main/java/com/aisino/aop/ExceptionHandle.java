package com.aisino.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aisino.msg.Msg;

/**
 * ClassName: ExceptionHandle 
 * @Description: controller 增强，用于全局捕获异常
 * @author zhukaishengy
 * @date 2017年11月3日
 */
@ControllerAdvice
public class ExceptionHandle {

	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	public Msg respose(){
		return Msg.fail();
	}
}
