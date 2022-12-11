package com.petshop.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class AuthorizationFilter extends HttpFilter implements Filter {

    public AuthorizationFilter() {
        super();
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest _request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)_request;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			boolean isAuthenticated = false, isAdmin = false;
			String userName = "";
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JCOOKIE") && cookie.getValue().equals("tran-thi-bao-ngoc")) {
					userName = "Bảo Ngọc";
					isAuthenticated = true;
				}
				else if (cookie.getName().equals("JCOOKIE") && cookie.getValue().equals("admin")) {
					userName = "Admin";
					isAuthenticated = true;
					isAdmin = true;
				}
			}
			if (isAuthenticated) {
				request.setAttribute("isAuthenticated", true);
				request.setAttribute("username", userName);
				request.setAttribute("isAdmin", isAdmin);
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
