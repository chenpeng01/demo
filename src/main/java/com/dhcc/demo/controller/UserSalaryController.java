/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.controller;

import java.io.IOException;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhcc.demo.entity.UserSalary;
import com.dhcc.demo.service.UserSalaryService;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-8
 */
@Controller
@RequestMapping(value = "usersalary.do")
public class UserSalaryController {
    
    @Autowired
    private UserSalaryService userSalaryService;
    
    @InitBinder("userSalary")    
    public void initBinder(WebDataBinder binder) {    
            binder.setFieldDefaultPrefix("userSalary.");    
    }    

    @RequestMapping(params = "save")
    public void saveUserSalaryById(@ModelAttribute UserSalary userSalary,HttpServletResponse response,HttpServletRequest request){

        userSalary.setUserid(userSalary.getUser().getId());
        
        boolean judgeIdNull = false;
        if(null == userSalary.getId()){
            judgeIdNull = true;
        }
        
//        List<UserSalary> userSalaryList = userSalaryService.findSalaryByUserId(userSalary.getUser().getId());
//        if(null != userSalaryList && userSalaryList.size() != 0){
//            userSalary.setId(userSalaryList.get(0).getId());
//        }
        
        boolean flag = userSalaryService.saveOrUpdateSalary(userSalary);
        
        String resultAdd = "";
        if(judgeIdNull){
            resultAdd = ",\"id\":\"" + userSalary.getId()+"\"";
        }
        else{
            resultAdd = ",\"id\":\"" + -1+"\"";
        }
            
        String resultJson = "";
        if(flag){
            resultJson = "{\"save\":\"true\"" + resultAdd + "}";
        }else{
            resultJson = "{\"save\":\"false\"}";
        }
        
        try {
            response.getWriter().print(resultJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
