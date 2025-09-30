<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
</head>
<body>
	<form action="/flow/edit-ok.product" method="get">
			<input type="hidden" name="id" value="${product.id}"/>
		<div>
			<span>상품명</span>
			<input name="productName" value="${product.productName}"/>
		</div>
		<div>
			<span>상품가격</span>
			<input name="productPrice" value="${product.productPrice}"/>
		</div>
		<div>
			<span>상품재고</span>
			<input name="productStock" value="${product.productStock}"/>
		</div>
		<button>등록완료!</button>
	</form>
</body>
</html>