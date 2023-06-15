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
 * 宠物信息表
 * 
 * @author hqsunc
 * @since 2017年3月7日
 * @see [Class/Method]
 *
 */
public class PetModel extends BasicModel {

    private String type;
    private String name;
    private String otherName;
    private String enName;
    private String weight;
    private String size;
    private String hairColor;
    private String image;
    private int statue;
    private String description;
    private Date createTime;
    private int staffId;
    private String staffName;
    private Date bCureTime;
    private Date cureTime;
    private int adoptId;
    private String adoptName;
    private String phone;
    private String address;
    private String adoptTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return the otherName
     */
    public String getOtherName() {
        return otherName;
    }

    /**
     * @param otherName
     *            the otherName to set
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    /**
     * @return the enName
     */
    public String getEnName() {
        return enName;
    }

    /**
     * @param enName
     *            the enName to set
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight
     *            the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the hairColor
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * @param hairColor
     *            the hairColor to set
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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

    /**
     * @return the staffId
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     *            the staffId to set
     */
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    /**
     * @return the staffName
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName
     *            the staffName to set
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * @return the bCureTime
     */
    public Date getbCureTime() {
        return bCureTime;
    }

    /**
     * @param bCureTime
     *            the bCureTime to set
     */
    public void setbCureTime(Date bCureTime) {
        this.bCureTime = bCureTime;
    }

    /**
     * @return the cureTime
     */
    public Date getCureTime() {
        return cureTime;
    }

    /**
     * @param cureTime
     *            the cureTime to set
     */
    public void setCureTime(Date cureTime) {
        this.cureTime = cureTime;
    }

    /**
     * @return the adoptId
     */
    public int getAdoptId() {
        return adoptId;
    }

    /**
     * @param adoptId
     *            the adoptId to set
     */
    public void setAdoptId(int adoptId) {
        this.adoptId = adoptId;
    }

    /**
     * @return the adoptName
     */
    public String getAdoptName() {
        return adoptName;
    }

    /**
     * @param adoptName
     *            the adoptName to set
     */
    public void setAdoptName(String adoptName) {
        this.adoptName = adoptName;
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
     * @return the adoptTime
     */
    public String getAdoptTime() {
        return adoptTime;
    }

    /**
     * @param adoptTime
     *            the adoptTime to set
     */
    public void setAdoptTime(String adoptTime) {
        this.adoptTime = adoptTime;
    }

}
