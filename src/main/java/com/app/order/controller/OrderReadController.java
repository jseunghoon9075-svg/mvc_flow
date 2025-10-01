package com.app.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.Action;
import com.app.Result;
import com.app.dao.OrderDAO;
import com.app.vo.ProductVO;

public class OrderReadController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		OrderDAO orderDAO = new OrderDAO();
		ProductVO productVO = new ProductVO();
		JSONArray product = new JSONArray();
		Long id = Long.parseLong(req.getParameter("id"));
		
		orderDAO.select(id).stream().map(JSONObject::new).forEach(product::put);
		req.setAttribute("product", product);
//		주문번호로 다른값을 참조해서 들고온다
//		System.out.println(found);
		result.setPath("/order/order_read.jsp");
		return result;
	}

}
