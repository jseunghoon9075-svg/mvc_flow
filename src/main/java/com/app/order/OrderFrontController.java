package com.app.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.order.controller.OrderListController;
import com.app.order.controller.OrderReadController;
import com.app.order.controller.OrderRemoveOkController;
import com.app.order.controller.OrderWriteCompleteController;
import com.app.order.controller.OrderWriteOkController;

public class OrderFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html, charset=UTF-8");
		
		Result result = null;
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		
		System.out.println(target);
		if(target.equals("write-ok")) {
			result = new OrderWriteOkController().execute(req, resp);
		}else if(target.equals("write-complete")) {
			result = new OrderWriteCompleteController().execute(req, resp);
		}else if(target.equals("list")) {
			result = new OrderListController().execute(req, resp);
		}else if(target.equals("read")){
			result = new OrderReadController().execute(req, resp);
		}else if(target.equals("remove-ok")){
			result = new OrderRemoveOkController().execute(req, resp);
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
