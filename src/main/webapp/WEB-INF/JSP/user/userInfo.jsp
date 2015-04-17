<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
<script src="${pageContext.request.contextPath}/jscript/jquery-1.11.2.js" ></script>
<script src="${pageContext.request.contextPath}/jscript/json2.js" > </script>
<script src="${pageContext.request.contextPath}/jscript/userinfo.js" > </script>
<script src="${pageContext.request.contextPath}/jscript/edituserinfo.js" > </script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userinfo.css">
</head>
<body>
	<table id="userInfoTable">
		<tr>
			<td>ID</td>
			<td>姓 名</td>
			<td>住 址</td>
			<td>电 话</td>
			<td>编 辑</td>
			<td>删 除</td>
		</tr>
		<c:forEach items="${userInfoList}" var="userInfo">
		    <tr id="<c:out value='${userInfo.user.id}'/>">
		        <td><c:out value="${userInfo.user.id}"></c:out></td>
				<td><c:out value="${userInfo.user.username}"></c:out></td>
				<td><c:out value="${userInfo.address}"></c:out></td>
				<td><c:out value="${userInfo.phone}"></c:out></td>
				<td><form method = "post" action="${pageContext.request.contextPath}/userinfo.do?edit&id=${userInfo.user.id}&username=${userInfo.user.username}" ><input type="submit" id="edit_<c:out value='${userInfo.user.id}'/>" value="编辑" /></form></td>
				<td ><input type="button" id="<c:out value='${userInfo.user.id}'/>" onclick="del('${pageContext.request.contextPath}','${userInfo.user.id}')" value="删除"></td> 
		    </tr>
	    </c:forEach>
	</table>
	<section id = "upload"><article>新  增</article></section>
	<section id = "new_user_section" class="hide_user_section">
		<article>
			<label>姓名：</label>
			<input type="text" id="username">
		</article>
		<article>
			<label>密码：</label>
			<input type="password" id="password" >
		</article>
		<article>
			<label>地址：</label>
			<input type="text" id="address" >
		</article>
		<article>
			<label>电话：</label>
			<input type="text" id="phone" >
		</article>
		<article>
			<button id="regist" >注   册</button>
		</article>
	</section>
</body>
</html>
















