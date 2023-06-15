/**
 * BannerMapper.java 2016年9月20日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.iss.sdb.pet.dao;

import java.util.List;

import com.iss.sdb.pet.models.MedicalAidModel;
import com.iss.sdb.pet.pojo.Page;

/**
 * MedicalAidMapper
 * 
 * @author hqsunc
 * @since 2016年10月11日
 *
 */
public interface MedicalAidMapper {

    /**
     * 
     * 分页查询宠物信息
     *
     * @author hqsunc
     * @param page
     *            分页模型
     * @return 宠物分页列表
     * @since 2016年11月18日
     */
    public List<MedicalAidModel> findPage(Page page);

    /**
     * 查询单个宠物信息
     *
     * @author hqsunc
     * @param id
     *            宠物标识符
     * @return 宠物Model对象
     * @since 2016年10月11日
     */
    public MedicalAidModel get(long id);

    /**
     * 
     * 新增申请
     *
     * @author hqsunc
     * @param medicalAidModel
     * @return
     * @since 2017年3月24日
     * @see
     */
    public int add(MedicalAidModel medicalAidModel);

    /**
     * 
     * 更新申请状态
     *
     * @author hqsunc
     * @param medicalAidModel
     * @return
     * @since 2017年3月24日
     * @see
     */
    public int updateStatue(MedicalAidModel medicalAidModel);

}
