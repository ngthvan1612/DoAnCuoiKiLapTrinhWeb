package com.petshop.servlets.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.hibernate.daos.OrderDAO;
import com.petshop.hibernate.daos.OrderDetailDAO;
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Order;
import com.petshop.hibernate.entities.OrderDetail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/don-hang")
public class SharedOrderController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	private final OrderDAO orderDAO;
	private final OrderDetailDAO orderDetailDAO;

    public SharedOrderController() {
        super();
    	this.productDAO = new ProductDAO();
		this.orderDAO = new OrderDAO();
		this.orderDetailDAO = new OrderDetailDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		List<Order> orders = null;
		List<OrderDetail> orderDetails = null;
		List<OrderView> orderViews = new ArrayList<>();
		
		orders = this.orderDAO.listOrders(1, 20);
		
		for (var order: orders)
		{
			OrderView orderView = new OrderView();
			orderView.setId(order.getId());
			orderView.setStatus(order.getStatus());
			orderDetails = this.orderDetailDAO.listOrderDetailsByOrderId(order.getId());
			orderView.setOrderDetails(orderDetails);
			orderViews.add(orderView);
		}
		
		request.setAttribute("listOrders", orderViews);
		request.getRequestDispatcher("/WEB-INF/templates/shared/order.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
