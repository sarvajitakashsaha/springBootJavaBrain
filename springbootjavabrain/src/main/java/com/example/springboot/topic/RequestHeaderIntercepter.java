package com.example.springboot.topic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component
public class RequestHeaderIntercepter extends HandlerInterceptorAdapter  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(StringUtils.isEmpty(request.getHeader("topic-key"))) {
			throw new InvalidHeaderFieldException("Invalid Header");
		}
		return super.preHandle(request, response, handler);
	}

	
	
}
