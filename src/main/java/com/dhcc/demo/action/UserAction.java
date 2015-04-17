/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.action;

/*import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;  
import org.apache.struts2.convention.annotation.Results;*/
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.dhcc.demo.service.UserServiceI;
import com.dhcc.demo.entity.User;
import com.dhcc.demo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author <a href="mailto:CP@dhcc.com.cn">CP</a>
 * @date 2015-3-26
 */
/*@ParentPackage("struts-default")
@Namespace("/struts") 
@Results( { @Result(name = "success", location = "/WEB-INF/struts/home.jsp"), @Result(name = "error", location = "/index.jsp") })
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
@InterceptorRefs({@InterceptorRef("defaultStack")})*/
public class UserAction extends ActionSupport{
    
    private static final long serialVersionUID = -1199432653730394287L;
    
    private User user;
    
    private UserService userService;
    
    @Override
    public String execute() throws Exception{
        
//      user.setId(0);
        System.out.println(userService);
        boolean flag = userService.userLogin(user);
        
        if (flag) {  
            return SUCCESS;
        } else {  
            return ERROR;  
        }  
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }  
       
}
