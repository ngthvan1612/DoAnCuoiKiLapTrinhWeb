package com.petshop.servlets.shared;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Product;
import com.petshop.servlets.shared.cart.CartItemManager;

@WebServlet("/gio-hang")
public class SharedCartController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;

    public SharedCartController() {
    	super();
    	this.productDAO = new ProductDAO();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String cartValue = null;
		
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("CART")) {
					cartValue = cookie.getValue(); 
				}
			}
		}
		
		if (cartValue == null) {
			cartValue = "";
		}
		
		CartItemManager cartItemManaged = new CartItemManager(cartValue);
		
		List<CartItem> cartItems = cartItemManaged.toListCartsItems();
		
		for (CartItem cartItem : cartItems) {
			int productId = cartItem.getProductId();
			Product product = this.productDAO.getProductById(productId);
			if (product != null) {
				String productName = product.getProductName();
				int productPrice = product.getPrice();
				
				cartItem.setProductName(productName);
				cartItem.setPrice(productPrice);
			}
		}
		
		request.setAttribute("cartItems", cartItems);
		request.getRequestDispatcher("/WEB-INF/templates/shared/cart.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		response.setStatus(405);
		
	}
}
