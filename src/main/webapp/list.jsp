<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트</title>
</head>
<body>
	<table>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>상품재고</th>
		</tr>
		<tr>
		</tr>
	</table>
	<a href="/flow"><button>메인페이지</button></a>
	<a href="/flow/add.product"><button>상품등록</button></a>
</body>
<script type="text/javascript">
	const productList = JSON.parse(`${productsList}`);
	const table = document.querySelector("table");
	
	productList.forEach((products) => {
	table.innerHTML += (
		"<tr>" +
			"<td>" + products.id + "</td>" +			
			"<td>" + '<a href="/flow/read.product?id=' + products.id + '">' + products.productName + "</a>" + "</td>" +	
			"<td>" + products.productPrice + "</td>" +			
			"<td>" + products.productStock + "</td>" +
		"</tr>"
		)
	})

</script>
</html>