package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.vo.ProductVO;

public class ProductListFrontController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		ProductDAO productDAO = new ProductDAO();
		ProductVO productVO = new ProductVO();
		JSONArray productList = new JSONArray();
		
		req.setAttribute("products", productDAO.selectAll());
//		데이터를 가져온 ArrayList를 스트림객체로 바꾸고 맵을 이용해 JSONObject 로 객체를 변경후 JSONArray에 데이터 삽입
		productDAO.selectAll().stream().map(JSONObject::new).forEach(productList::put);
		req.setAttribute("productsList", productList);
		result.setPath("/product/list.jsp");
		return result;
	}

}
