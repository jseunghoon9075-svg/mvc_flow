package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.exception.ProductExceptionController;
import com.app.vo.ProductVO;

public class ProductEditController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		ProductDAO productDAO = new ProductDAO();
		ProductVO productVO = new ProductVO();
		Long id = Long.parseLong(req.getParameter("id"));

		ProductVO foundProduct = productDAO.selectOne(id).orElseThrow(ProductExceptionController::new);
		
		try {
			req.setAttribute("product", foundProduct);
		} catch (ProductExceptionController e) {
			req.setAttribute("message", "ProdcutEditController에서 예외발생");
			result.setPath("/error.jsp");
		}
		result.setPath("/edit.jsp");
		return result;
	}

}
