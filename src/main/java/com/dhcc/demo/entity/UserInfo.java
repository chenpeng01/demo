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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-3
 */
@Entity
@Table(name = "user_info")
public class UserInfo implements java.io.Serializable{

    private static final long serialVersionUID = 3615588853786378792L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name="id")
    private User user;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name="userid")
    private Integer userid;
    
    @Column(name = "deletebit")
    private int deletebit;
    
    public UserInfo() {
    }

    public UserInfo(Integer id, User user, String address, String phone, int deletebit) {
        super();
        this.id = id;
        this.user = user;
        this.address = address;
        this.phone = phone;
        this.deletebit = deletebit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDeletebit() {
        return deletebit;
    }

    public void setDeletebit(int deletebit) {
        this.deletebit = deletebit;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "\"id\":" + id + ", \"address\":\"" + address + "\", \"phone\":\"" + phone + "\", \"userid\":" + userid + ", \"deletebit\":\"" + deletebit + "\"," + user;
    }
}
