/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.demo.dao.UserDaoI;
import com.dhcc.demo.utils.DeleteEnum;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-8
 */
@Service("allService")
public class AllService {
    @Autowired
    private UserDaoI userDaoI;
    
    public boolean deleteUser(int id,DeleteEnum deleteEnum){
        boolean flag = false;
        
        flag = userDaoI.deleteBit(id, deleteEnum);
        
        return flag;
    }
}
