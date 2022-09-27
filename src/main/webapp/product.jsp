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
	        <table>
	            <thead>
                    <tr>
                        <td>id</td>
                        <td>name</td>
                        <td>price</td>
                        <td>discount</td>
                        <td>description</td>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${products}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${item.discount}</td>
                            <td>${item.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
	        </table>
	    </div>

		<form method="POST" action="${pageContext.request.contextPath}/api/products">
            <div>
				<label>name<label>
				<input type="text" name="name"/>
			</div>
			<div>
            	<label>price<label>
            	<input type="text" name="price"/>
            </div>
			<div>
            	<label>discount<label>
            	<input type="text" name="discount"/>
            </div>
			<div>
            	<label>description<label>
            	<input type="text" name="description"/>
            </div>
            <input type="submit">
		</form>
	</body>
</html>