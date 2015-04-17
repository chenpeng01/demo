/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhcc.demo.dao.UserDaoI;
import com.dhcc.demo.entity.User;
import com.dhcc.demo.utils.DeleteEnum;


/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-3-31
 */
@Service("userService")
@Transactional
public class UserService{

    @Autowired
    private UserDaoI userDaoI;
    
    public void setUserDaoI(UserDaoI userDaoI) {
        this.userDaoI = userDaoI;
    }
    
    /**
     * 登陆
     */
    public boolean userLogin(User user) throws Exception {
        boolean flag = false;
        List<User> userList = this.getUserByNamePasword(user);
        
        if(userList !=null && userList.size()>0){
            flag = true;
        }
        
        return flag;
    }
    
    /**
     * find
     */
    public List<User> getUserByNamePasword(User user){
        
        @SuppressWarnings("unchecked")
        List<User> userList = (List<User>)userDaoI.loadUser(user);
        
        return userList;
    }
    
    /**
     * 新增
     */
    public boolean userSave(User user){
        
        boolean flag = userDaoI.saveUser(user);
        
        return flag;
    }
    
    /**
     * 检索用户
     */
    public List<User> userAll(DeleteEnum deleteEnum){
        
        List<User> userList = userDaoI.getUserAll(deleteEnum);
        
        return userList;
    }
    
    public boolean deleteUser(int id,DeleteEnum deleteEnum){
        
        boolean flag = userDaoI.deleteBit(id, deleteEnum);
        
        return flag;
    }
    
    public List<User> getUserById(int id){
        List<User> userList = userDaoI.getUserById(id);
        
        return userList;
    }
}
