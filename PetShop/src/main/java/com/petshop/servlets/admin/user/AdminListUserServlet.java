package com.petshop.servlets.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.daos.UserDAO;
import com.petshop.hibernate.entities.User;

@WebServlet("/admin/user-management")
public class AdminListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserDAO userDAO;
       
    public AdminListUserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		
	    List<User> users = this.userDAO.listUsers(currentPage, limit);
	    long numberOfUsers = this.userDAO.numberOfUsers();
        
        request.setAttribute("listUsers", users);
        request.setAttribute("pageSize", numberOfUsers);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/user-management/list-user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

}