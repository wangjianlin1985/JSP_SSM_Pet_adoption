/**
 * UserModel.java 2016年10月11日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.iss.sdb.pet.models;

import java.util.Date;

import com.iss.sdb.commons.persistence.BasicModel;

/**
 * <summary>
 * <description>
 * 
 * @author hqsunc
 * @since 2016年10月11日
 * @see [Class/Method]
 *
 */
public class UserModel extends BasicModel {

    private String userName;

    private String password;

    private String name;

    private int sex;

    private String idCard;

    private int role;

    private String email;

    /**
     * 账号状态(0删除、1正常、2到期、3试用)
     */
    private int status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * @return the id
     * @see UserModel#id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     * @see UserModel#id
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex
     *            the sex to set
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     *            the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
