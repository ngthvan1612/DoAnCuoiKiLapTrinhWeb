package com.petshop.servlets.admin.feedback;

import java.io.IOException;
import java.util.List;

import com.petshop.hibernate.daos.FeedBackDAO;
import com.petshop.hibernate.entities.FeedBack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/feedbacks")
public class ListFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final FeedBackDAO feedbackDAO;

  public ListFeedbackServlet() {
  	super();
  	this.feedbackDAO = new FeedBackDAO();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1, limit = 20;
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<FeedBack> feedBacks = this.feedbackDAO.listFeedBacks(page, limit);
		System.out.println("OKKK");
		for (FeedBack feedBack : feedBacks) {
			System.out.println(feedBack.getId() + " " + feedBack.getFullName() + " " + feedBack.getPhoneNumber() + " " + feedBack.getEmail());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}
}
