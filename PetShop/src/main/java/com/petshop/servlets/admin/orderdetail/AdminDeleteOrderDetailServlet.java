package com.petshop.servlets.admin.orderdetail;

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
import com.petshop.hibernate.daos.OrderDetailDAO;
import com.petshop.hibernate.entities.OrderDetail;

@WebServlet("/admin/orderDetail-management/delete")
public class AdminDeleteOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderDetailDAO orderDetailDAO;
	
    public AdminDeleteOrderDetailServlet() {
        super();
        this.orderDetailDAO = new OrderDetailDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		int orderDetailId = Integer.parseInt(request.getParameter("id"));
		
		this.orderDetailDAO.deleteOrderDetailById(orderDetailId);
		
        request.setAttribute("success_messages", new String[] { "Tạo chi tiết giỏ hàng thành công" });
        
        RequestDispatcher rd = request.getRequestDispatcher("/admin/orderDetail-management");
        rd.include(request, response);
        
		response.sendRedirect("/PetShop/admin/orderDetail-management");
	}
}