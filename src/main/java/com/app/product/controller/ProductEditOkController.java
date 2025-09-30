package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.vo.ProductVO;

public class ProductEditOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		ProductDAO productDAO = new ProductDAO();
		ProductVO productVO = new ProductVO();
		String productName = null;
		Integer productPrice = null, productStock = null;
		Long id = Long.parseLong(req.getParameter("id"));
		
		productName = req.getParameter("productName");
		productPrice = Integer.parseInt(req.getParameter("productPrice"));
		productStock = Integer.parseInt(req.getParameter("productStock"));
		
		productVO.setId(id);
		productVO.setProductName(productName);
		productVO.setProductPrice(productPrice);
		productVO.setProductStock(productStock);
		
		productDAO.update(productVO);
		
		result.setRedirect(true);
		result.setPath("/flow/list.product");
		return result;
	}

}
