package com.petshop.servlets.shared;

import java.io.IOException;
import java.util.List;

import com.petshop.hibernate.daos.AnimalDAO;
import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.entities.Animal;
import com.petshop.hibernate.entities.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BaseSharedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AnimalDAO animalDAO;
	private final CategoryDAO categoryDAO;
       
    public BaseSharedServlet() {
        super();
        
        this.animalDAO = new AnimalDAO();
        this.categoryDAO = new CategoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//NAV-BAR
		List<Animal> animals = this.animalDAO.listAnimals(0, 90000);
	    List<Category> categories = this.categoryDAO.listCategorys(0, 9000);
        
        request.setAttribute("listAnimals", animals);
        request.setAttribute("listCategories", categories);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khong co gi o day het
	}
}
