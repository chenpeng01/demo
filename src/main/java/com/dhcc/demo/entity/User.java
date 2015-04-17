/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author <a href="mailto:CP@dhcc.com.cn">CP</a>
 * @date 2015-3-26
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable{
    
    private static final long serialVersionUID = -3485373797537513904L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne(mappedBy="userid")
    private Integer  id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "deletebit")
    private int deletebit;

    public User() {
    }

    public User(String name, String password, int deletebit) {
        super();
        this.username = name;
        this.password = password;
        this.deletebit = deletebit;
    }

    
    public Integer  getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getDeletebit() {
        return deletebit;
    }

    public void setDeletebit(int deletebit) {
        this.deletebit = deletebit;
    }

    @Override
    public String toString() {
        return "\"user\":{\"id\":" + id + ",\"username\":\"" + username + "\",\"password\":\"" + password + "\",\"deletebit\":" + deletebit+"}";
    }
}
