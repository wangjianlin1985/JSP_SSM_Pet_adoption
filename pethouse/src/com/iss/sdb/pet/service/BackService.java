/**
 * BackService.java 2016年9月19日
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
import com.iss.sdb.pet.dao.BackMapper;
import com.iss.sdb.pet.dao.PetMapper;
import com.iss.sdb.pet.models.BackModel;
import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.pojo.Page;

/**
 * BackService
 * 
 * @author hqsunc
 * @since 2016年10月12日
 *
 */
@Service
@Transactional
public class BackService {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(BackService.class);

    /**
     * backMapper
     */
    @Autowired
    private BackMapper backMapper;

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
    public List<BackModel> findPage(Page page) {
        logger.debug("BackService findPage begin" + page);

        List<BackModel> result = backMapper.findPage(page);

        logger.debug("BackService findPage end" + result);

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
    public BackModel get(Long id) {
        logger.debug("BackService get begin " + id);

        BackModel result = backMapper.get(id);

        logger.debug("BackService get end" + result);

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
    @OperateLog(verb = OperateVerb.ADD, noun = "新增宠物领回申请")
    public int add(BackModel back) {
        logger.debug("BackService add begin " + back);
        int result = backMapper.add(back);
        logger.debug("BackService add end" + result);

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
    public int updateStatue(BackModel back) {
        logger.debug("BackService updateStatue begin" + back);
        int result = backMapper.updateStatue(back);
        PetModel pet = new PetModel();
        pet.setId(new Long(back.getPetId()));
        if (back.getStatue() == 2) {
            pet.setStatue(7);
        }
        petMapper.updateStatue(pet);
        logger.debug("BackService updateStatue end" + result);
        return result;
    }

}
