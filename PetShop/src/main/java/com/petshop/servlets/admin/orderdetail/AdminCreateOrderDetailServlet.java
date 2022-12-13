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

@WebServlet("/admin/orderDetail-management/create")
public class AdminCreateOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderDetailDAO orderDetailDAO;
       
    public AdminCreateOrderDetailServlet() {
        super();
        this.orderDetailDAO = new OrderDetailDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDetail orderDetail = new OrderDetail();
		
		
		
		orderDetail.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		
		
		orderDetail.setOrderId(Integer.parseInt(request.getParameter("orderId")));
		
		
		
		orderDetail.setProductId(Integer.parseInt(request.getParameter("productId")));
		
		
		
		this.orderDetailDAO.createOrderDetail(orderDetail);
		
		request.setAttribute("success_messages", new String[] { "Tạo chi tiết giỏ hàng thành công" });
		response.sendRedirect("/PetShop/admin/orderDetail-management?page=1&limit=50");
	}
}