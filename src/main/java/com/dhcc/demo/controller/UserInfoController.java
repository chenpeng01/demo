/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhcc.demo.entity.User;
import com.dhcc.demo.entity.UserInfo;
import com.dhcc.demo.entity.UserSalary;
import com.dhcc.demo.service.AllService;
import com.dhcc.demo.service.UserInfoService;
import com.dhcc.demo.service.UserSalaryService;
import com.dhcc.demo.service.UserService;
import com.dhcc.demo.utils.DeleteEnum;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-3
 */
@Controller
@RequestMapping(value = "userinfo.do")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AllService allService;
    
    @Autowired
    private UserSalaryService userSalaryService;
    
    @RequestMapping(params = "getall")
    public String getAllUserInifo(Model model){
        
        List<User> userList = userService.userAll(DeleteEnum.UNDELETE);
        
        Map<Integer,UserInfo> userInfoMap = userInfoService.getAllUserInfo(DeleteEnum.UNDELETE);
        
        User user = null;
        
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        
        for(Iterator<User> userIte = userList.iterator();userIte.hasNext();)
        {
            user = userIte.next(); 
            
            int index = user.getId();
            
            UserInfo userInfo = userInfoMap.get(index);
            userInfo.setUser(user);
            
            userInfoList.add(userInfo);
        }
        model.addAttribute("userInfoList", userInfoList);
        
        return "user/userInfo";
    }
    
    @RequestMapping(params = "delete")
    public void deleteUserById(@RequestParam String userid,HttpServletResponse response,HttpServletRequest request){
        
        int id = Integer.parseInt(userid);
        try {
            allService.deleteUser(id, DeleteEnum.DELETE);
            response.getWriter().print("{\"del\":\"true\"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(params = "save")
    public void saveUserInfo(@RequestParam String jsonstr,HttpServletResponse response,HttpServletRequest request){
        
        
        String phone = (String)JSONObject.fromObject(jsonstr).getString("phone");  
        String address = (String)JSONObject.fromObject(jsonstr).getString("address");
        JSONObject userJson = (JSONObject) JSONObject.fromObject(jsonstr).get("user");
        String username = (String) userJson.get("username");
        String password = (String) userJson.get("password");
        
        User userBean = new User();
        userBean.setPassword(password);
        userBean.setUsername(username);
        userBean.setDeletebit(DeleteEnum.UNDELETE.getValue());
        
        boolean flagUser = userService.userSave(userBean);
        
        JSONObject result = null;
        
        if(flagUser){
           boolean flagUserInfo = false;
           
           List<User> userList = userService.getUserByNamePasword(userBean);
           userBean = userList.get(0);
           UserInfo userInfoBean = new UserInfo();
           
           userInfoBean.setAddress(address);
           userInfoBean.setDeletebit(DeleteEnum.UNDELETE.getValue());
           userInfoBean.setPhone(phone);
           userInfoBean.setUser(userBean);
           userInfoBean.setUserid(userBean.getId());
           
           flagUserInfo = userInfoService.saveUserInfo(userInfoBean);
           if(flagUserInfo){
               String jsonString = "{\"save\":\"true\","+userInfoBean.toString()+"}";
               result = JSONObject.fromObject(jsonString);
               
           }else{
               result = JSONObject.fromObject("{\"save\":\"flag\"}");
           }
        }
        else{
            result = JSONObject.fromObject("{\"save\":\"false\"}");
        }
        
        try {
            response.getWriter().print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping(params = "edit")
    public String editSalary(String id,String username,HttpServletResponse response,HttpServletRequest request){
        
        int userId = Integer.parseInt(id);
        List<UserSalary> userSalaryList = userSalaryService.findSalaryByUserId(userId);
        User user = new User();
        user.setId(userId);
        user.setUsername(username);
        
        if(null != userSalaryList && userSalaryList.size() !=0){
            userSalaryList.get(0).setUser(user);
            request.setAttribute("userSalaryList", userSalaryList);
            
        }else{
            UserSalary userSalary = new UserSalary();
            userSalary.setUser(user);
            userSalary.setSalary(0.0);
            userSalaryList.add(userSalary);
            request.setAttribute("userSalaryList", userSalaryList);
        }
            
        return "user/salary_edit";
    }
}
