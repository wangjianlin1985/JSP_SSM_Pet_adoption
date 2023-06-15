/**
 * AdoptService.java 2016年9月19日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.iss.sdb.pet.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iss.sdb.commons.logs.OperateLog;
import com.iss.sdb.commons.logs.OperateVerb;
import com.iss.sdb.pet.dao.AdoptMapper;
import com.iss.sdb.pet.dao.PetMapper;
import com.iss.sdb.pet.models.AdoptModel;
import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.pojo.Page;

/**
 * AdoptService
 * 
 * @author hqsunc
 * @since 2016年10月12日
 *
 */
@Service
@Transactional
public class AdoptService {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(AdoptService.class);

    /**
     * adoptMapper
     */
    @Autowired
    private AdoptMapper adoptMapper;
    
    /**
     * PetMapper
     */
    @Autowired
    private PetMapper petMapper;

    /**
     * 方法描述：分页查询用户信息列表
     *
     * @author hqsunc
     * @param page
     *            分页模型
     * @return 用户信息列表
     * @since 2016年11月18日
     */
    public List<AdoptModel> findPage(Page page) {
        logger.debug("AdoptService findPage begin" + page);

        List<AdoptModel> result = adoptMapper.findPage(page);

        logger.debug("AdoptService findPage end" + result);

        return result;

    }

    /**
     * 
     * 根据标识ID获取用户信息
     *
     * @author hqsunc
     * @param id
     * @return
     * @since 2017年3月7日
     * @see
     */
    public AdoptModel get(Long id) {
        logger.debug("AdoptService get begin " + id);

        AdoptModel result = adoptMapper.get(id);

        logger.debug("AdoptService get end" + result);

        return result;
    }

    /**
     * 方法描述：添加用户信息
     *
     * @author hqsunc
     * @param pet
     *            用户信息
     * @return 持久化操作码
     * @since 2016年11月18日
     * @see
     */
    @OperateLog(verb = OperateVerb.ADD, noun = "新增宠物")
    public int add(AdoptModel adopt) {
        logger.debug("AdoptService add begin " + adopt);
        int result = adoptMapper.add(adopt);
        PetModel pet=new PetModel();
        pet.setId(new Long(adopt.getPetId()));
        pet.setStatue(2);
        petMapper.updateStatue(pet);
        logger.debug("AdoptService add end" + result);

        return result;
    }

    /**
     * 
     * 方法描述：更新宠物状态
     *
     * @author hqsunc
     * @param pet
     * @return
     * @since 2017年3月23日
     * @see
     */
    public int updateStatue(AdoptModel adopt) {
        logger.debug("AdoptService updateStatue begin" + adopt);
        int result = adoptMapper.updateStatue(adopt);
        PetModel pet=new PetModel();
        pet.setId(new Long(adopt.getPetId()));
        if(adopt.getStatue()==2){
            pet.setStatue(3);
        }else if(adopt.getStatue()==3){
            pet.setStatue(1);
        }
        petMapper.updateStatue(pet);
        logger.debug("AdoptService updateStatue end" + result);
        return result;
    }

}
