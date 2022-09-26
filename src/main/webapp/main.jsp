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
		<form method="POST">
			<div>
				<label>Продукты<label>
				<select name="product">
					  <c:forEach items="${products}" var="item">
					    <option value="${item.id}">${item.name}>${item.price}</option>
					  </c:forEach>
				</select>
			</div>
			<input type="submit">
		</form>
	</body>
</html>