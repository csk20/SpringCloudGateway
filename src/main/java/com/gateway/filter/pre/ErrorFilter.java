package com.gateway.filter.pre;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import com.netflix.util.Pair;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@ConditionalOnProperty(prefix = "zuul.routes.errorfilter", name = "enabled", havingValue = "true", matchIfMissing = true)
public class ErrorFilter  {
	private static final String PCF_ROUTE_ERROR = "X-Cf-Routererror";

	
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		boolean shouldFilter = getErrorHeader(ctx) != null;

		return shouldFilter;
	}


	public Object run() throws ZuulException {

		
		
		return null;
	}

	
	public String filterType() {

		return "post";
	}

	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	private String getErrorHeader(RequestContext ctx) {

		for (Pair<String, String> pair : ctx.getZuulResponseHeaders()) {
			if (pair.first().equals(PCF_ROUTE_ERROR))
				return pair.second();
		}

		return null;
	}

	public static class routingException extends ZuulException{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public routingException( String sMessage, int nStatusCode, String errorCause) {
			super( sMessage, nStatusCode, errorCause);
			// TODO Auto-generated constructor stub
		}
		
	}
	
}
