/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.demo.dao.UserInfoDaoI;
import com.dhcc.demo.entity.UserInfo;
import com.dhcc.demo.utils.DeleteEnum;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-3
 */
@Service("userInfoService")
public class UserInfoService {
    
    @Autowired
    private UserInfoDaoI userInfoDaoI;
    
    /**
     * 所有人员信息
     */
    public Map<Integer,UserInfo> getAllUserInfo(DeleteEnum deleteEnum){
        
        Map<Integer,UserInfo> userInfoMap = userInfoDaoI.getAllUserInfo(deleteEnum);
        

        return userInfoMap;
    }
    
    /**
     * 更新信息
     */
    public boolean updateUserInfo(UserInfo userInfo){
        boolean flag =  userInfoDaoI.updateUserInfoById(userInfo);
        
        return flag;
    }
    /**
     * 保存
     * 
     */
    public boolean saveUserInfo(UserInfo userInfo){
        boolean flag = userInfoDaoI.saveUserInfo(userInfo);
        return flag;
    }
}
