/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhcc.demo.dao.UserSalaryDaoI;
import com.dhcc.demo.entity.UserSalary;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-8
 */
@Service("userSalaryService")
@Transactional
public class UserSalaryService {

    @Autowired
    private UserSalaryDaoI userSalaryDaoI;
    
    public boolean saveOrUpdateSalary(UserSalary userSalary){
        boolean flag = userSalaryDaoI.saveorUpdateUserSalary(userSalary);
        
        return flag;
    }
    
    public List<UserSalary> findSalaryByUserId(int id){

        List<UserSalary> userSalaryList  = userSalaryDaoI.findUserSalaryByUserId(id);
        
        return userSalaryList;
    }

    public UserSalaryDaoI getUserSalaryDaoI() {
        return userSalaryDaoI;
    }

    public void setUserSalaryDaoI(UserSalaryDaoI userSalaryDaoI) {
        this.userSalaryDaoI = userSalaryDaoI;
    }
    
}
