<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>展示Demo</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td>爱好</td>
			<td>生日</td>
			<td>操作</td>
		</tr>
		<c:forEach var="demo" items="${demos }">
			<tr>
				<td><c:out value="${demo.id }" /></td>
				<td><c:out value="${demo.name }" /></td>
				<td><c:out value="${demo.hobits }" /></td>
				<td><fmt:formatDate value="${demo.birthday }" pattern="yyyy-MM-dd"/></td>
				<td><a href="${pageContext.request.contextPath }/demo/remove/${demo.id }">删除</a></td>
				<td><a href="${pageContext.request.contextPath }/demo/update/${demo.id }">修改</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="${pageContext.request.contextPath }/demo/add">添加</a></td>
		</tr>
	</table>
</body>
</html>