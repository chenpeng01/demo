<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>登录界面</title>  
    </head>  
      
    <body>  
         <form action="login.action" method="post">  
            <jsp:useBean id="user" scope="page" class="com.dhcc.demo.entity.User"/>
			<jsp:setProperty name="user" property="*"/>
			
            name:<input type="text" name="user.username" />  
            password:<input type="password" name="user.password" /> 

            <input type="submit" value="登录" />  
        </form>   
    </body>  
</html>  