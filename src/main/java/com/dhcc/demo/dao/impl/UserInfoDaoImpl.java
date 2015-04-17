/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dhcc.demo.dao.UserInfoDaoI;
import com.dhcc.demo.entity.User;
import com.dhcc.demo.entity.UserInfo;
import com.dhcc.demo.utils.DeleteEnum;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-3
 */
@Repository
public class UserInfoDaoImpl extends HibernateDaoSupport implements UserInfoDaoI {

    @Override
    public List<User> getUserInfoById(User user) {
        
        String sql = "from User as u where u.id = " + user.getId();
        
        @SuppressWarnings("unchecked")
        List<User> userList = this.getHibernateTemplate().find(sql);
        
        return userList;
    }

    @Override
    public boolean saveUserInfo(UserInfo userInfo) {
        boolean flag = false;
        
        try{
            this.getHibernateTemplate().save(userInfo);
            flag = true;
        }
        catch(RuntimeException re){
            re.printStackTrace();
        }
        
        return flag;
    }

    @Override
    public boolean updateUserInfoById(UserInfo userInfo) {
        boolean flag = false;
        
        try{
            this.getHibernateTemplate().update(userInfo);
            flag = true;
        }catch(RuntimeException re){
            
        }
        
        return flag;
    }

    @Override
    public Map<Integer,UserInfo> getAllUserInfo(DeleteEnum deleteEnum) {
        
        String sql = "from UserInfo as ui ";
        
        if(DeleteEnum.ALL == deleteEnum || DeleteEnum.DELETE == deleteEnum || DeleteEnum.UNDELETE == deleteEnum){
            sql = sql + " where ui.deletebit = " + deleteEnum.getValue();
        }
        
        @SuppressWarnings("unchecked")
        List<UserInfo> userList = this.getHibernateTemplate().find(sql);
        
        Map<Integer, UserInfo> usermap = new HashMap<Integer ,UserInfo>();
        
        for(Iterator<UserInfo> userInfoIte = userList.iterator();userInfoIte.hasNext();){
            
            UserInfo userInfo = userInfoIte.next();
            usermap.put(userInfo.getUserid(),userInfo);
        }
        
        return usermap;
    }

}
