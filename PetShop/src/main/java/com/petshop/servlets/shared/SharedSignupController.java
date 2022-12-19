package com.petshop.servlets.shared;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SharedSignupController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;

    public SharedSignupController() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		request.getRequestDispatcher("/WEB-INF/templates/shared/signup.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		super.doPost(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(address);
		System.out.println(phoneNumber);
		response.sendRedirect("/PetShop");
				

		response.setStatus(405);
	}

}
