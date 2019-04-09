package com.ssafy.controller;

import com.ssafy.vo.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodController foodController = FoodController.getInstance();
	private UserController userController = UserController.getInstance();
	private AccountController accountController = AccountController.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    process(request, response);
	}

	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		PageInfo page = null;

		try {
			switch (action) {
			    // Food
                case "foodList": page = foodController.getFoodList(req, res); break;
				case "view": page = foodController.getFoodDetail(req, res); break;
				case "search": page = foodController.searchBy(req, res); break;
                // Account
				case "login": page = accountController.login(req, res); break;
				case "logout": page = accountController.logout(req, res); break;
				case "signUp": page = accountController.signUp(req, res); break;
				case "mypage": page = accountController.getUserInfo(req, res); break;
				case "updateUser": page = accountController.updateUser(req, res); break;
				case "userList": page = accountController.getUserList(req, res); break;
				case "userDelete": page = accountController.deleteUser(req, res); break;
				// User
				case "order": page = userController.doPurchase(req, res); break;
				case "orderList": page = userController.getPurchaseListByUser(req, res); break;

//				// 도서 관련
//				case "bookDelete": page = bookController.delete(req, res); break;
			}

			if (page.isForward()) {
				req.getRequestDispatcher(page.getUrl()).forward(req, res);
				return;
			} else {
				res.sendRedirect(page.getUrl());
				return;
			}
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
	}
}
