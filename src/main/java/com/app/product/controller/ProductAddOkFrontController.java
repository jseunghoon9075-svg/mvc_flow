package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.vo.ProductVO;

public class ProductAddOkFrontController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		상품 등록
		Result result = new Result();
		ProductDAO productDAO = new ProductDAO();
		ProductVO productVO = new ProductVO();
		String addProductName = null;
		Integer addProductPrice = null, addProductStock = null;
		
		addProductName = req.getParameter("productName");  
		addProductPrice = Integer.parseInt(req.getParameter("productPrice"));
		addProductStock = Integer.parseInt(req.getParameter("productStock"));
		
		productVO.setProductName(addProductName);
		productVO.setProductPrice(addProductPrice);
		productVO.setProductStock(addProductStock);
		
		productDAO.insert(productVO);
		
		result.setRedirect(true);
		result.setPath("/flow/list.product");
		return result;
	}

}
