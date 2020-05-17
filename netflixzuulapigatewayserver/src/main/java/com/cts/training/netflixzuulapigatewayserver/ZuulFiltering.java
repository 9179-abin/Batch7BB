package com.cts.training.netflixzuulapigatewayserver;




import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Component;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;



@Component
public class ZuulFiltering extends ZuulFilter {



	@Override
	public String filterType() {
	    return "pre";
	}

	@Override
	public int filterOrder() {
	    return 10;
	}

	@Override
	public boolean shouldFilter() {
	    return true;
	}
	
	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    
	    ctx.addZuulRequestHeader("Authorization", request.getHeader("Authorization"));

	    
	    return null;
	}
	 
	

}
