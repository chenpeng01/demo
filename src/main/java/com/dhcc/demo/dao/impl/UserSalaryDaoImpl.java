/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dhcc.demo.dao.UserSalaryDaoI;
import com.dhcc.demo.entity.UserSalary;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-3
 */
@Repository
public class UserSalaryDaoImpl extends HibernateDaoSupport implements UserSalaryDaoI {

    @Override
    public boolean saveorUpdateUserSalary(UserSalary userSalary) {
        
        boolean flag = false;
        
        try{
            this.getHibernateTemplate().saveOrUpdate(userSalary);
            flag = true;
        }
        catch(DataAccessException e){
            
        }
        
        return flag;
    }

    @Override
    public boolean updateUserSalary(UserSalary userSalary) {
        
        boolean flag = false;
        
        try{
            this.getHibernateTemplate().update(userSalary);
            flag = true;
        }
        catch(DataAccessException e){
            
        }
        
        return flag;
    }

    @Override
    public List<UserSalary> findUserSalaryByUserId(int id) {
        
        String sql = " FROM UserSalary as us where userid = " + id;
        
        @SuppressWarnings("unchecked")
        List<UserSalary> userSalaryList = this.getHibernateTemplate().find(sql);
        
        return userSalaryList;
    }
}
