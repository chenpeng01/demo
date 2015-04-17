<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>登录成功</title>  
    </head>  
      
    <body>
         Hello <s:text name="user.username"></s:text>!
         <form method = "post" action="${pageContext.request.contextPath}/userinfo.do?getall">
         	 <input type="submit" value="获取详细信息"/>
         </form>
    </body>
</html>