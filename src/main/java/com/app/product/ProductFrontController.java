package com.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.member.controller.MemberJoinController;
import com.app.member.controller.MemberJoinOkController;
import com.app.member.controller.MemberLoginController;
import com.app.member.controller.MemberLoginOkController;
import com.app.member.controller.MemberLogoutOkController;
import com.app.product.controller.ProductAddFrontController;
import com.app.product.controller.ProductAddOkFrontController;
import com.app.product.controller.ProductEditController;
import com.app.product.controller.ProductEditOkController;
import com.app.product.controller.ProductListFrontController;
import com.app.product.controller.ProductReadController;

public class ProductFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html, charset=UTF-8");
		
		Result result = null;
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		System.out.println("요우청");
		
		if(target.equals("add")) {
			result = new ProductAddFrontController().execute(req, resp);
		}else if(target.equals("add-ok")) {
			result = new ProductAddOkFrontController().execute(req, resp);
		}else if(target.equals("edit")) {
			result = new ProductEditController().execute(req, resp);
		}else if(target.equals("edit-ok")) {
			result = new ProductEditOkController().execute(req, resp);
		}else if(target.equals("list")){	
			result = new ProductListFrontController().execute(req, resp);
		}else if(target.equals("read")){
			result = new ProductReadController().execute(req, resp);
		}else if(target.equals("remove-ok")){	
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
