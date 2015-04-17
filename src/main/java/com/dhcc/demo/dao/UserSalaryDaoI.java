/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dhcc.demo.entity.UserSalary;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-3
 */
@Repository
public interface UserSalaryDaoI {
    public boolean saveorUpdateUserSalary(UserSalary userSalary);
    
    public boolean updateUserSalary(UserSalary userSalary);
    
    public List<UserSalary> findUserSalaryByUserId(int id);
}
