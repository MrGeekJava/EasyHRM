<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加 Demo</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/demo/addOK" method="post">
		编号：<input name="id"><br/>
		姓名：<input name="name"><br/>
		爱好：<input type="checkbox" name="hobits" value="足球">足球
			  <input type="checkbox" name="hobits" value="篮球">篮球
			  <input type="checkbox" name="hobits" value="羽毛球">羽毛球
		生日：<input name="birthday"><br/>
		<input type="submit" value="修改">
	</form>
</body>
</html>