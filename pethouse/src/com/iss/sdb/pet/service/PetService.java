/**
 * PetService.java 2016年9月19日
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
import com.iss.sdb.pet.dao.PetMapper;
import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.pojo.Page;

/**
 * PetService
 * 
 * @author hqsunc
 * @since 2016年10月12日
 *
 */
@Service
@Transactional
public class PetService {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(PetService.class);

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
    public List<PetModel> findPage(Page page) {
        logger.debug("PetService findPage begin" + page);

        List<PetModel> result = petMapper.findPage(page);

        logger.debug("PetService findPage end" + result);

        return result;

    }
    
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
    public List<PetModel> findList(PetModel pet) {
        logger.debug("PetService findList begin"+pet);

        List<PetModel> result = petMapper.findList(pet);

        logger.debug("PetService findList end" + result);

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
    public PetModel get(Long id) {
        logger.debug("PetService get begin " + id);

        PetModel result = petMapper.get(id);

        logger.debug("PetService get end" + result);

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
    public int add(PetModel pet) {
        logger.debug("PetService add begin " + pet);
        int result = petMapper.add(pet);
        logger.debug("PetService add end" + result);

        return result;
    }

    /**
     * 方法描述：更新宠物信息
     *
     * @author hqsunc
     * @param pet
     *            用户信息模型
     * @return 持久化操作码
     * @since 2016年11月18日
     */
    @OperateLog(verb = OperateVerb.MODIFY, noun = "修改宠物信息")
    public int update(PetModel pet) {
        logger.debug("PetService update begin" + pet);
        int result = petMapper.update(pet);
        logger.debug("PetService update end" + result);
        return result;

    }
    
    /**
     * 
     * 医治
     *
     * @author hqsunc
     * @param pet
     * @return
     * @since 2017年3月24日
     * @see
     */
    @OperateLog(verb = OperateVerb.MODIFY, noun = "医治宠物信息")
    public int cure(PetModel pet) {
        logger.debug("PetService cure begin" + pet);
        int result = petMapper.cure(pet);
        logger.debug("PetService cure end" + result);
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
    public int updateStatue(PetModel pet) {
        logger.debug("PetService updateStatue begin" + pet);
        int result = petMapper.updateStatue(pet);
        logger.debug("PetService updateStatue end" + result);
        return result;
    }

    /**
     * 方法描述：删除用户信息
     *
     * @author hqsunc
     * @param id
     *            用户ID
     * @return 持久化操作码
     * @since 2016年11月18日
     */
    @OperateLog(verb = OperateVerb.DEL, noun = "删除用户信息")
    public int delete(PetModel pet) {
        logger.debug("PetService delete begin " + pet);
        int result = petMapper.delete(pet);
        logger.debug("PetService delete end " + result);
        return result;
    }

}
