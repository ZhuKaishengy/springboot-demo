package com.aisino.exceptionCatcher;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aisino.to.Msg;

/**
 * @Description: 全局捕获异常
 * @author zhukaishengy
 * @date 2017年11月16日
 */
@ControllerAdvice
public class ExceptionHandle {

	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	public Msg respose(){
		return Msg.fail();
	}
}
