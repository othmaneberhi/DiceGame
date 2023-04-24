package com.ensah.dicegame.web.Filters;

import com.ensah.dicegame.bo.Message;
import com.ensah.dicegame.bo.MessageTypes;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/secure/*")
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getSession().getAttribute("user")==null){
            request.setAttribute("message",new Message("You are not authenticated, Please login. ", MessageTypes.WARNING));
            request.getRequestDispatcher("/WEB-INF/vues/LoginPage.jsp").forward(request,response);
            return;
        }
        filterChain.doFilter(request,response);

    }
}
