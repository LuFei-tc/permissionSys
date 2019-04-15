package com.ycsf.persys.common.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class PSFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		   WebUtils.issueRedirect(request, response, "/index");
//		   WebUtils.redirectToSavedRequest(request, response, "/index");
		   return false;
	}
	
}
