package com.petshop.servlets.shared;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.daos.OrderDAO;
import com.petshop.hibernate.daos.OrderDetailDAO;
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Order;
import com.petshop.hibernate.entities.OrderDetail;
import com.petshop.hibernate.entities.Product;
import com.petshop.servlets.shared.cart.CartItemManager;

@WebServlet("/thanh-toan")
public class SharedPaymentPageController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	private final CategoryDAO categoryDAO;
	private final OrderDAO orderDAO;
	private final OrderDetailDAO orderDetailDAO;

    public SharedPaymentPageController() {
        super();
        
        this.productDAO = new ProductDAO();
		this.categoryDAO = new CategoryDAO();
		this.orderDAO = new OrderDAO();
		this.orderDetailDAO = new OrderDetailDAO();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	super.doGet(request, response);
		
		request.getRequestDispatcher("/WEB-INF/templates/shared/paymentpage.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	super.doPost(request, response);
    	
    	String fullName = request.getParameter("fullName");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String isCod = request.getParameter("isCod");
		String note = request.getParameter("note");
		
		//Save
		
		System.out.println(fullName);
		System.out.println(phoneNumber);
		System.out.println(address);
		System.out.println(isCod);
		System.out.println(note);
		
		CartItemManager cartItemManaged = this.getCartItemManager(request, response);
		
		Order order = new Order();
		order.setFullName(fullName);
		order.setPhoneNumber(phoneNumber);
		order.setAddress(address);
		order.setOrderMethod("COD");
		order.setNote(note);
		
		this.orderDAO.createOrder(order);
		
		for (CartItem cartItem : cartItemManaged.toListCartsItems()) {
			OrderDetail orderDetail = new OrderDetail();
			
			orderDetail.setOrderId(order.getId());
			orderDetail.setProductId(cartItem.getProductId());
			orderDetail.setQuantity(cartItem.getNum());
			
			this.orderDetailDAO.createOrderDetail(orderDetail);
		}
		
		response.addCookie(new Cookie("CART", ""));
		response.sendRedirect("/PetShop");
	}
}
