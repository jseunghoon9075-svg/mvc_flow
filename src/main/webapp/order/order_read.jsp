<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문상품 상세정보</title>
</head>
<body>
	<a href="/flow/list.order">
		<h1 id="header">주문상품 상세정보</h1>
	</a>
	<ul id="order-read-wrap">
		
	</ul>
	<a class="remove-btn"><button>주문삭제</button></a>
</body>
<script type="text/javascript">
	const productOne = JSON.parse(`${product}`)
	const ul = document.querySelector("#order-read-wrap")
	const removeLink = document.querySelector(".remove-btn")
	console.log(productOne)
	
	productOne.forEach((product) => {
		removeLink.href = "/flow/remove-ok.order?id=" + product.id
		ul.innerHTML += (
				"<li>상품번호: " + product.productId + "</li>" +
				"<li>상품명: " + product.productName + "</li>" +
				"<li>개당 상품가격: " + product.productPrice + "원</li>" +
				"<li>상품재고: " + product.productStock + "개</li>" 
		)
	})
</script>
</html>