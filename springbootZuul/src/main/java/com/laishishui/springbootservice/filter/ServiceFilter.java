package com.laishishui.springbootservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.ZuulServletFilter;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Create by tachai on 2021/2/23 3:58 下午
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Component
public class ServiceFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre"; // 定义filter的类型，有pre、route、post、error四种
    }

    @Override
    public int filterOrder() {
        return 0; // 定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true; // 表示是否需要执行该filter，true表示执行，false表示不执行
    }

    @Override
    public Object run() {
        // filter需要执行的具体操作
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        System.out.println(token);
        if(token==null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("there is no request token");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }

}
