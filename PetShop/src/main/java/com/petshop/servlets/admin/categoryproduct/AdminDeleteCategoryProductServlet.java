package com.petshop.servlets.admin.categoryproduct;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.daos.CategoryProductDAO;
import com.petshop.hibernate.entities.CategoryProduct;

@WebServlet("/admin/categoryProduct-management/delete")
public class AdminDeleteCategoryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryProductDAO categoryProductDAO;
	
    public AdminDeleteCategoryProductServlet() {
        super();
        this.categoryProductDAO = new CategoryProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		int categoryProductId = Integer.parseInt(request.getParameter("id"));
		
		this.categoryProductDAO.deleteCategoryProductById(categoryProductId);
		
        request.setAttribute("success_messages", new String[] { "Tạo CategoryProduct thành công" });
        
        RequestDispatcher rd = request.getRequestDispatcher("/admin/categoryProduct-management");
        rd.include(request, response);
        
		response.sendRedirect("/PetShop/admin/categoryProduct-management");
	}
}