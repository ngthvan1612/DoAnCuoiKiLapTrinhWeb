package com.petshop.servlets.shared;

import java.io.IOException;
import java.util.List;

import com.petshop.hibernate.daos.AnimalDAO;
import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Animal;
import com.petshop.hibernate.entities.Category;
import com.petshop.hibernate.entities.Product;
import com.petshop.servlets.shared.cart.CartItemManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BaseSharedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AnimalDAO animalDAO;
	private final CategoryDAO categoryDAO;
	private final ProductDAO productDAO;
	
    public BaseSharedServlet() {
        super();
        
        this.animalDAO = new AnimalDAO();
        this.categoryDAO = new CategoryDAO();
        this.productDAO = new ProductDAO();
    }
    
    protected CartItemManager getCartItemManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartValue = "";
		
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("CART")) {
					cartValue = cookie.getValue(); 
				}
			}
		}
		
		CartItemManager cartItemManaged = new CartItemManager(cartValue);
		
		return cartItemManaged;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//NAV-BAR
		List<Animal> animals = this.animalDAO.listAnimals(0, 90000);
	    List<Category> categories = this.categoryDAO.listCategorys(0, 9000);
        
        request.setAttribute("listAnimals", animals);
        request.setAttribute("listCategories", categories);
        
        //Cart
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//NAV-BAR
		List<Animal> animals = this.animalDAO.listAnimals(0, 90000);
	    List<Category> categories = this.categoryDAO.listCategorys(0, 9000);
        
        request.setAttribute("listAnimals", animals);
        request.setAttribute("listCategories", categories);
        
        //Cart
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
	}
}
