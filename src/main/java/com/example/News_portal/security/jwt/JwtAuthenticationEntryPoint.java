package com.example.News_portal.security.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String responseMsg = "Unauthorized. Full authentication is required to access this resource";
        httpServletResponse.getWriter().write(responseMsg);
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
