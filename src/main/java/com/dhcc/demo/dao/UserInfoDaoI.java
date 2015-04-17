/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dhcc.demo.entity.User;
import com.dhcc.demo.entity.UserInfo;
import com.dhcc.demo.utils.DeleteEnum;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-3
 */
@Repository
public interface UserInfoDaoI {
    public List<User> getUserInfoById(User user);
    
    public boolean saveUserInfo(UserInfo userInfo);
    
    public boolean updateUserInfoById(UserInfo userInfo);
    
    public Map<Integer,UserInfo> getAllUserInfo(DeleteEnum deleteEnum);
    
}
