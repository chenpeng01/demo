<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add or change salary</title>
<script src="${pageContext.request.contextPath}/jscript/jquery-1.11.2.js" ></script>
<script src="${pageContext.request.contextPath}/jscript/editsalary.js" > </script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/salary.css">
</head>
<body>
	<section class="main">
		<article>
			<header>
				<ul>
					<li><label>userID</label></li>
					<li><label>name</label></li>
					<li><label>salary</label></li>
				</ul>
			</header>
			<article>
				<c:forEach items="${userSalaryList}" var="userSalary">
					<ul>
						<li><label id="userid" align="center"><c:out value="${userSalary.user.id}"/></label> </li>
						<li id="username"><label align="center" id="<c:out value='${userSalary.id}' />"><c:out value="${userSalary.user.username}"/></label></li>
						<li class="salary"><input type="text" id="salaryvalue" class="old_li_input"  value="<c:out value='${userSalary.salary}'/>" /></li>
						<li><button align="center" id="savebutton" >  save </button> </li>
					</ul>
				</c:forEach>
			</article>
		</article>
	</section>
</body>
</html>