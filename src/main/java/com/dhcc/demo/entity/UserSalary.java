/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.entity;

import java.io.Serializable;

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
@Table(name = "user_salary")
public class UserSalary implements Serializable {

    private static final long serialVersionUID = -4941799584726063080L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name="id")
    private User user;
    @Column(name = "userid")
    private int userid;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "deletebit")
    private int deletebit;
   
    
    public UserSalary() {
    }

    public UserSalary(Integer id, User user, Double salary, int deletebit) {
        this.id = id;
        this.user = user;
        this.salary = salary;
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
    
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getDeletebit() {
        return deletebit;
    }

    public void setDeletebit(int deletebit) {
        this.deletebit = deletebit;
    }

    @Override
    public String toString() {
        return "UserSalary [id=" + id + ", user=" + user +",userid="+ userid + ", salary=" + salary + ", deletebit=" + deletebit + "]";
    }
    
}
