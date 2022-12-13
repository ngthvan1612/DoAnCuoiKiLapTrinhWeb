package com.petshop.servlets.admin.orderdetail;

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
import com.petshop.hibernate.daos.OrderDetailDAO;
import com.petshop.hibernate.entities.OrderDetail;

@WebServlet("/admin/orderDetail-management")
public class AdminListOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderDetailDAO orderDetailDAO;
       
    public AdminListOrderDetailServlet() {
        super();
        this.orderDetailDAO = new OrderDetailDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		
	    List<OrderDetail> orderDetails = this.orderDetailDAO.listOrderDetails(currentPage, limit);
	    long numberOfOrderDetails = this.orderDetailDAO.numberOfOrderDetails();
        
        request.setAttribute("listOrderDetails", orderDetails);
        request.setAttribute("pageSize", numberOfOrderDetails);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/orderDetail-management/list-orderDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

}