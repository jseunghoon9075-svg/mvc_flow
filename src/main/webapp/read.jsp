<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품조회</title>
</head>
<body>
	<div class="wrap">
		<a href="/flow/list.product"><button>상품목록</button></a>
		<a class="update-btn"><button>상품수정</button></a>
		<a class="delete-btn"><button>상품삭제</button></a>
	</div>
</body>
<script type="text/javascript">
	const product = JSON.parse(`${productJSON}`)
	const data = document.querySelector(".wrap")
	const updateLink = document.querySelector(".update-btn")
	const deleteLink = document.querySelector(".delete-btn")
	console.log(product)
	
	updateLink.href = "/flow/edit.product?id="+ product.id
	deleteLink.href = "/flow/delete-ok.product?id="+ product.id
	
	data.innerHTML += (
	"<p>상품번호: " + product.id + "</p>" +		
	"<p>상품명: " + product.productName + "</p>" +		
	"<p>상품가격: " + product.productPrice + "원</p>" +		
	"<p>상품재고: " + product.productStock + "개</p>"
	)

</script>

</html>