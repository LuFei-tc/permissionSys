package com.ycsf.persys.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionResolver{
	
	@ExceptionHandler
	@ResponseBody
	public ErrorInfo shiroExceptionResolve(HttpServletRequest req,Exception e) {
		ErrorInfo info = new ErrorInfo() ;
		if(e instanceof AuthorizationException) {
			info.setCode(ErrorInfo.ACCESS_DENIED);
			info.setMessage(e.getMessage());
			info.setUrl(req.getRequestURL().toString());
		}else if(e instanceof MailSendException) {
			info.setCode(ErrorInfo.ADDR_FAILED);
			info.setMessage("邮箱地址无效");
		}
		 
		return info;
	}
}
