package com.petshop.servlets.admin.productimage;

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
import com.petshop.hibernate.daos.ProductImageDAO;
import com.petshop.hibernate.entities.ProductImage;

@WebServlet("/admin/productImage-management/delete")
public class AdminDeleteProductImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductImageDAO productImageDAO;
	
    public AdminDeleteProductImageServlet() {
        super();
        this.productImageDAO = new ProductImageDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		int productImageId = Integer.parseInt(request.getParameter("id"));
		
		this.productImageDAO.deleteProductImageById(productImageId);
		
        request.setAttribute("success_messages", new String[] { "Tạo hình ảnh sản phẩm thành công" });
        
        RequestDispatcher rd = request.getRequestDispatcher("/admin/productImage-management");
        rd.include(request, response);
        
		response.sendRedirect("/PetShop/admin/productImage-management");
	}
}