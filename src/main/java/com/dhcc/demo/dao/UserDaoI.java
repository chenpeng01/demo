/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dhcc.demo.entity.User;
import com.dhcc.demo.utils.DeleteEnum;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-1
 */
@Repository
public interface UserDaoI {
    @SuppressWarnings("rawtypes")
    public List loadUser(User detachedInstance);
    
    public List<User> getUserAll(DeleteEnum deleteEnum);
    
    public boolean deleteBit(int id,DeleteEnum deleteEnum);
    
    public boolean saveUser(User user);
    
    public List<User> getUserById(int id);
}
