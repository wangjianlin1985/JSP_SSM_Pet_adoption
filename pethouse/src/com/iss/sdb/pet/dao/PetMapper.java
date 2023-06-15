/**
 * BannerMapper.java 2016年9月20日
 * 
 * Copyright 2001-2016  All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.iss.sdb.pet.dao;

import java.util.List;

import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.pojo.Page;

/**
 * UserMapper
 * 
 * @author hqsunc
 * @since 2016年10月11日
 *
 */
public interface PetMapper {

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
    public List<PetModel> findPage(Page page);
    
    /**
     * 
     * <summary>
     * <description>
     *
     * @author hqsunc
     * @param pet
     * @return
     * @since 2017年3月27日
     * @see
     */
    public List<PetModel> findList(PetModel pet);

    /**
     * 查询单个宠物信息
     *
     * @author hqsunc
     * @param id
     *            宠物标识符
     * @return 宠物Model对象
     * @since 2016年10月11日
     */
    public PetModel get(long id);

    /**
     * 根据条件获取所有宠物信息列表
     * 
     * @return
     */
    public List<PetModel> findAll();

    /**
     * 新增宠物
     *
     * @author hqsunc
     * @param PetModel
     *            宠物模型
     * @return 持久化操作返回码
     * @since 2016年10月11日
     */
    public int add(PetModel PetModel);

    /**
     * 更新宠物信息
     *
     * @author hqsunc
     * @param PetModel
     *            宠物模型
     * @return 持久化操作返回码
     * @since 2016年9月22日
     */
    public int update(PetModel PetModel);
    
    /**
     * 
     * 医治
     *
     * @author hqsunc
     * @param PetModel
     * @return
     * @since 2017年3月24日
     * @see
     */
    public int cure(PetModel PetModel);
    
    
    /**
     * 更新宠物状态
     *
     * @author hqsunc
     * @param PetModel
     *            宠物模型
     * @return 持久化操作返回码
     * @since 2016年9月22日
     */
    public int updateStatue(PetModel PetModel);
    

    /**
     * 
     * 删除宠物信息
     *
     * @author hqsunc
     * @param PetModel
     * @return
     * @since 2017年3月7日
     * @see
     */
    public int delete(PetModel PetModel);
}
