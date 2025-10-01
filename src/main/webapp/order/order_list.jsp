<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 리스트</title>
</head>
<style>
#order-list-wrap {
	display: flex;
	align-content: space-around;
	gap: 40px;
}
</style>
<body>
	<a href="/flow"><h1 id="header">주문 리스트</h1></a>
	<ul id="order-list-wrap">
		
	</ul>
</body>
<script type="text/javascript">
	const orderList = JSON.parse(`${orderList}`);
	const ul = document.querySelector("#order-list-wrap")
	const header = document.querySelector("#header")
	
	orderList.forEach((order) => {
		ul.innerHTML += (
			"<li>" + 
				"<a href='/flow/read.order?id="+order.id+"'>" +
						"상품명: " + order.productName
				+ "</a>" 
				+ "<p>총 주문가격: " + order.orderTotalPrice + "</p>"
				+ "<p>주문수량: " + order.productCount+ "</p>"
				+ "<p>주문자: " + order.memberName + "</p>"
			+ "</li>"	
		)
	})
</script>
</html>