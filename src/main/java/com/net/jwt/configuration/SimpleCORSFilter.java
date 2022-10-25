package com.net.jwt.configuration;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleCORSFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        String domain = "http://localhost:3000";

        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", domain);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "PATCH, POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Expose-Headers", "*, Content-disposition");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, x-api-key, admin-sid, content-disposition, " +
                "x-requested-with,  Cache-Control, Expires, Last-Modified, Pragma, clientType, widgetKey, storeName, Authorization, X-Auth-Token");
        chain.doFilter(req, res);
    }

}
