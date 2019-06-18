package com.yao.sc.servicezuul.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ThrowExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 9;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
       /* ctx.setSendZuulResponse(false);//false表示不发送路由响应给消费端，即不会去路由请求后端服务
        ctx.getResponse().setContentType("text/html;charset=UTF-8");
        ctx.setResponseBody("token验证不通过，禁止访问！");
        ctx.setResponseStatusCode(401);
        log.info("token验证不通过，禁止访问！");*/

        try {
            doSomething();
        } catch (ZuulException e) {
            e.printStackTrace();
            request.setAttribute("javax.servlet.error.status_code", 500);
            request.setAttribute("javax.servlet.error.exception", e);
            request.setAttribute("javax.servlet.error.message",e.getMessage());
        }
         return null;
    }

    private void doSomething() throws ZuulException{
        throw new ZuulException("Exists some errors",500,"Error!");
    }
}
