package com.petshop.servlets.shared;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.hibernate.daos.AnimalDAO;
import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.*;

@WebServlet("/san-pham")
public class SharedProductPageController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	
    public SharedProductPageController() {
        super();
        
        this.productDAO = new ProductDAO();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		List<Product> products = null;
		
		if (request.getParameter("categoryId") != null) {
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			products = this.productDAO.listProductsByCategoryId(categoryId, 1, 20);
		}
		else {
			products = this.productDAO.listProducts(1, 20);
		}
		
		request.setAttribute("listProducts", products);
		request.getRequestDispatcher("/WEB-INF/templates/shared/product.jsp").forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		response.setStatus(405);
	}
}
