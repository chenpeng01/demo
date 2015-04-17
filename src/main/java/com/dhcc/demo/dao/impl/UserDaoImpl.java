/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dhcc.demo.dao.UserDaoI;
import com.dhcc.demo.entity.User;
import com.dhcc.demo.utils.DeleteEnum;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-1
 */
@Repository
public class UserDaoImpl  extends HibernateDaoSupport implements UserDaoI{

    @SuppressWarnings({ "unchecked" })
    public List<User> loadUser(User user) {

        String hql = "from User as u where u.username = '"+ user.getUsername() +"' and u.password= '" + user.getPassword()+"' and u.deletebit = " + DeleteEnum.UNDELETE.getValue();
        
//        Session session =  this.getHibernateTemplate().getSessionFactory().openSession();
        
//        Query query = session.createQuery(hql);
//        query.setParameter(0, user.getUsername());
//        query.setParameter(1, user.getPassword());
       
        List<User> list = this.getHibernateTemplate().find(hql);
        
        return list;   
    }

    @Override
    public boolean deleteBit(int id,DeleteEnum deleteEnum) {
        
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        String sql = "Update User set deletebit = " +deleteEnum.getValue() + " where id = " + id;
        Query queryupdate=session.createQuery(sql);
        int flagint = queryupdate.executeUpdate();
        trans.commit();
        session.close();
        
        boolean flag = false;
        if(1 == flagint){
            flag = true;
        }
        
        return flag;
    }

    @Override
    public List<User> getUserAll(DeleteEnum deleteEnum) {
        
        String sql = "from User as u";
        
        sql = sql + this.makeSql(deleteEnum);
        
        @SuppressWarnings({ "unchecked" })
        List<User> userList = this.getHibernateTemplate().find(sql);
        
        return userList;
    }
    
    
    private String makeSql(DeleteEnum deleteEnum){
        
        String sql = "";
        
        if(DeleteEnum.DELETE == deleteEnum || DeleteEnum.UNDELETE == deleteEnum){
            sql = sql + " where u.deletebit = " + deleteEnum.getValue();
        }
        
        return sql;
    }

    @Override
    public boolean saveUser(User user) {
        
        boolean flag = false;
        
        try{
            this.getHibernateTemplate().save(user);
            flag = true;
        }
        catch(RuntimeException re){
            re.printStackTrace();
        }
        
        return flag;
    }

    @Override
    public List<User> getUserById(int id) {
        
        String sql = "from User as u where u.id = " + id;
        
        @SuppressWarnings("unchecked")
        List<User> userList = this.getHibernateTemplate().find(sql);
        
        return userList;
    }
}
