package com.gateway.filter.pre;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class MyFirstPreFilter  {
	
	private static Logger log = LoggerFactory.getLogger(MyFirstPreFilter.class);

	
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public Object run()  {
		RequestContext ctx= RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		long startTime=System.currentTimeMillis();
try {
	String path=	(String) ctx.get("Request uri key");
	ThreadContext.put("request id", request.getHeader("request id"));
	ThreadContext.put("start time", String.valueOf(startTime));
	
}catch (Exception e) {
	  log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
}finally {
	  log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
}
		
	    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		return null;
	}


	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}


	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
