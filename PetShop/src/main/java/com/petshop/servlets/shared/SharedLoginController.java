package com.petshop.servlets.shared;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class SharedLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SharedLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("isAuthenticated") != null && (boolean)request.getAttribute("isAuthenticated")) {
			response.sendRedirect("/PetShop");
		}
		else
			request.getRequestDispatcher("/WEB-INF/templates/shared/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.printf("Username = %s\nPassword = %s\n", username, password);
		
		if (username.equals("admin") && password.equals("123abc")) {
			response.addCookie(new Cookie("JCOOKIE", "admin"));
			response.sendRedirect("/PetShop");
		}
		else if (username.equals("baongoc") && password.equals("123456")) {
			response.addCookie(new Cookie("JCOOKIE", "tran-thi-bao-ngoc"));
			response.sendRedirect("/PetShop");
		}
		else {
			request.setAttribute("error_messages", new String[] { "Tên đăng nhập hoặc mật khẩu không đúng" });
			request.getRequestDispatcher("/WEB-INF/templates/shared/login.jsp").forward(request, response);
		}
	}
}
