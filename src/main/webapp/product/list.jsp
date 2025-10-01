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
	<table id="product-table">
		<tr>
			<th>선택</th>
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
	<hr />
	
	<form id="order-form" action="write-ok.order" method="post">
		<h2>주문 정보</h2>
		<table id="order-table">
			<tr>
				<th>상품명</th>
				<th>상품가격</th>
				<th>주문수량</th>
			</tr>
		</table>
		<button id="order-button" type="button" style="display:none;">주문하기</button>
	</form>
	
</body>
<script type="text/javascript">
	const productList = JSON.parse(`${productsList}`);
	const productTable = document.querySelector("#product-table");
	const orderForm = document.querySelector("#order-form");
	
	productList.forEach(({id, productName, productPrice, productStock}) => {
		productTable.innerHTML += (
		"<tr>" +
			"<td>" + "<input name='productId' type='checkbox' value='"+ id +"'/>" + "</td>" +			
			"<td>" + id + "</td>" +			
			"<td>" + '<a href="/flow/read.product?id=' + id + '">' + productName + "</a>" + "</td>" +	
			"<td>" + productPrice + "</td>" +			
			"<td>" + productStock + "</td>" +
		"</tr>"
		)
	})
	NodeList.prototype.find = Array.prototype.find;
	NodeList.prototype.filter = Array.prototype.filter;
	
	const inputs = document.querySelectorAll("#product-table input");
	const orderTable = document.querySelector("#order-table")
	const button = document.querySelector("#order-button")
	
	
	inputs.forEach((input) => {
		input.addEventListener("click", (e) => {
			const orderId = e.target.value
			const selectProduct = productList.find((product) => product.id === Number(orderId))
			const {id, productName, productPrice, productStock} = selectProduct
			const tr = document.createElement("tr");
			
			tr.innerHTML = (
				"<tr>" +
					"<input name='productId' type='hidden' value='"+ id +"'/>" +			
					"<td>" + productName + "</td>" +
					"<td>" + productPrice+ "</td>" +
					"<td>" + "<input name='productCount' value='1' min='1' />"+ "</td>" +
				"</tr>"
			)
			if(e.target.checked){
				/* 체크박스를 선택했다면 orderTable에 tr을 만들어서 추가 */
				orderTable.appendChild(tr);	
				button.style.display = "block";
			}else {
				/* 체크박스 해제되었을 때 해당 데이터를 삭제 */
				const trs = document.querySelectorAll("#order-table > tr")
				const selectTrs = trs.find((tr) => tr.childNodes[0].value === orderId)
				orderTable.removeChild(selectTrs)
				
				const removedTrs = document.querySelectorAll("#order-table > tr")
				button.style.display = trs.length === 0 ? "none" : "block";
			}
		})
	})
	
	button.addEventListener("click", (e) => {
		/* 버블링막기 */
		e.preventDefault();
		  const producIdInputs = document.querySelectorAll("#order-table input[name='productId']")
	      const productCountInputs = document.querySelectorAll("#order-table input[name='productCount']")
	      const submitState = [false, false]
	      
	      /* 주문 재고 수량이 0 */
	      if(productCountInputs.filter((input) => Number(input.value) !== 0).length !== productCountInputs.length){
	         return alert("주문 수량이 없습니다. 😅")
	      }else {
	         submitState[0] = true;
	      }
	      
	      /* 가지고 있는 상품의 재고 수량보다 구매 수량이 많을 때 */
	      productCountInputs.forEach((_, i) => {
	         const productId = producIdInputs[i].value;
	         const orderCount = productCountInputs[i].value;
	         const orderedProduct = productList.find(({id}) => String(id) === productId);
	         
	         if(orderCount > orderedProduct.productStock){
	            return alert("구매수량이 상품 수량보다 많습니다.")
	         }else {
	            submitState[1] = true; 
			 }
			})
			if(submitState.filter((flag) => flag).length === 2){
			orderForm.submit();
			}		
		
		
		
	})

</script>
</html>