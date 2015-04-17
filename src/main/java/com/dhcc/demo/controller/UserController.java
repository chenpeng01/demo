/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhcc.demo.entity.User;
import com.dhcc.demo.service.UserService;
import com.dhcc.demo.utils.DeleteEnum;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-3-30
 */
@Controller
@RequestMapping(value = "user.do")
public class UserController {
   
    @Autowired
    private UserService userService;
    
    @RequestMapping(params = "getall")
    public String getAll(Model model){
        //传 String Date number request bean array
        //返回 json
        //参数
        
        List<User> userList = userService.userAll(DeleteEnum.UNDELETE);
        
        model.addAttribute("userList", userList);
        
        for(Iterator<User> userIte = userList.iterator();userIte.hasNext();)
        {
            System.out.println("user = " + userIte.next());
        }
        
        return "user/userInfo";
    }
    
    @RequestMapping(params = "save")
    public String saveUser(User user){
        boolean flag =  userService.userSave(user);
        
        if(flag){
            return "user/save_success";
        }
        else{
            return "user/save_faile";
        }
    }
}
