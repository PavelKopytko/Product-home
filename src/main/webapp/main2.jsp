<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Список продуктов</title>
	</head>

	<body>
			<div>
				<label>Продукты<label>
				<ul>
					  <c:forEach items="${products}" var="item">
					    <li value="${item.id}">${item.id}. ${item.name} price=${item.price}
					    discount=${item.discount} description=${item.description}</li>
					  </c:forEach>
				</ul>
			</div>
	</body>
</html>