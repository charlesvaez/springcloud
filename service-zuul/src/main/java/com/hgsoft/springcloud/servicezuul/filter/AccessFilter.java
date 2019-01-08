package com.hgsoft.springcloud.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessFilter  extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        log.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());

        String access_token = request.getParameter("access_token");
        if(StringUtils.isBlank(access_token) || !"test".equals(access_token)){
            // zuul过滤该请求
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token is invalid");
            log.info("the request {} is fail, the token is invalid", request.getRequestURL().toString());
        } else {
            log.info("the request {} is ok", request.getRequestURL().toString());
        }
        return null;

    }
}
