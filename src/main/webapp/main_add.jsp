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
		<form method="POST" action="${pageContext.request.contextPath}/add">

            <div>
                <label>Название</label>
                    <textarea name="name"></textarea>
            </div>

            <div>
                <label>Стоимость</label>
                    <textarea name="price"></textarea>
            </div>

            <div>
                <label>Скидка</label>
                    <textarea name="discount"></textarea>
            </div>

            <div>
                <label>Описание</label>
                    <textarea name="description"></textarea>
            </div>

			<input type="submit">
		</form>
	</body>
</html>