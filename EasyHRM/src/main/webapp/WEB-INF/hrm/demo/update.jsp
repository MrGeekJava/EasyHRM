<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改Demo</title>

</head>
<body>
	<form action="${pageContext.request.contextPath }/hrm/demo/updateOK" method="post">
		编号：<input name="id" value="${demo.id }" readonly="readonly"><br/>
		姓名：<input name="name" value="${demo.name }"><br/>
		爱好：<input name="hobits" value="${demo.hobits }" ><br/>
		生日：<input name="birthday" value="<fmt:formatDate value="${demo.birthday}" pattern="yyyy-MM-dd"/>  " ><br/>
		<input type="submit" value="修改">
	</form>
</body>
</html>