package com.hardworking.training.filter;

import com.hardworking.training.model.User;
import com.hardworking.training.service.JWTService;
import com.hardworking.training.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "SecurityFilter",urlPatterns = "/*")
public class SecurityFilter implements Filter {
    @Autowired
    JWTService jwtService;
    @Autowired
    UserService userService;
    private static final Set<String> IGNORED_PATHS = new HashSet<>(Arrays.asList("/auth","/users/create"));
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    int statusCode = authorization(request);
    if (statusCode==HttpServletResponse.SC_ACCEPTED) filterChain.doFilter(request,servletResponse);
    else ((HttpServletResponse)servletResponse).sendError(statusCode);
    }

    @Override
    public void destroy() {

    }
    public int authorization(HttpServletRequest request){
        int statusCode= HttpServletResponse.SC_UNAUTHORIZED;
        String uri= request.getRequestURI();
        String verb=request.getMethod();
        if (IGNORED_PATHS.contains(uri))return HttpServletResponse.SC_ACCEPTED;
        try {
            String token = request.getHeader("Authorization").replaceAll("^(.*?) ", "");
            if (token==null||token.isEmpty()) return statusCode;

            Claims claims = jwtService.decyptToken(token);

            if (claims.getId()!=null){
                User u =userService.getUserById(Long.parseLong(claims.getId()));
                if (u!=null && u.isActiveStatus() )statusCode=HttpServletResponse.SC_ACCEPTED;
            }
            String allowedResources = "/";
            switch(verb) {
                case "GET"    : allowedResources = (String)claims.get("allowedReadResources");   break;
                case "POST"   : allowedResources = (String)claims.get("allowedCreateResources"); break;
                case "PUT"    : allowedResources = (String)claims.get("allowedUpdateResources"); break;
                case "DELETE" : allowedResources = (String)claims.get("allowedDeleteResources"); break;
            }
            // /employees/id 200 "allowedReadResources": "/employees,/ems,/acnts,/accounts",
            // /paystubs/id  403 "allowedReadResources": "/employees,/ems,/acnts,/accounts",
            for (String s : allowedResources.split(",")) {
                if (uri.trim().toLowerCase().startsWith(s.trim().toLowerCase())) {
                    statusCode = HttpServletResponse.SC_ACCEPTED;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }return statusCode;
    }
}
