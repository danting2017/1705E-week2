<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<table>
		<tr>
			<td>商品id</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品百分比</td>
		</tr>
		<c:forEach items="${leftPop}" var="l">
			<td>${l.id }</td>
			<td>${l.name }</td>
			<td>${l.price }</td>
			<td>${l.baifenbi }</td>
		</c:forEach>
	</table>
</form>
</body>
</html>