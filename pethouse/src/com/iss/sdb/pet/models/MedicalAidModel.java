/**
 * PetModel.java 2017年3月7日
 * 
 * Copyright 2001-2017 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.iss.sdb.pet.models;

import java.util.Date;

import com.iss.sdb.commons.persistence.BasicModel;

/**
 * 宠物领养记录信息表
 * 
 * @author hqsunc
 * @since 2017年3月7日
 * @see [Class/Method]
 *
 */
public class MedicalAidModel extends BasicModel {

    private int petId;
    private String petName;
    private String image;
    private int userId;
    private String userName;
    private String contacts;
    private String phone;
    private String address;
    private int statue;
    private Date createTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the petId
     */
    public int getPetId() {
        return petId;
    }

    /**
     * @param petId
     *            the petId to set
     */
    public void setPetId(int petId) {
        this.petId = petId;
    }

    /**
     * @return the petName
     */
    public String getPetName() {
        return petName;
    }

    /**
     * @param petName
     *            the petName to set
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     *            the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
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
     * @return the contacts
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * @param contacts
     *            the contacts to set
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the statue
     */
    public int getStatue() {
        return statue;
    }

    /**
     * @param statue
     *            the statue to set
     */
    public void setStatue(int statue) {
        this.statue = statue;
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
