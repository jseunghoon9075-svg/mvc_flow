package com.app.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Action;
import com.app.Result;
import com.app.dao.OrderDAO;

public class OrderRemoveOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		OrderDAO orderDAO = new OrderDAO();
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		orderDAO.delete(id);
		
		result.setRedirect(true);
		result.setPath("/flow/list.order");
		return result;
	}

}
