/**
 * MedicalAidService.java 2016年9月19日
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
import com.iss.sdb.pet.dao.MedicalAidMapper;
import com.iss.sdb.pet.dao.PetMapper;
import com.iss.sdb.pet.models.MedicalAidModel;
import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.pojo.Page;

/**
 * MedicalAidService
 * 
 * @author hqsunc
 * @since 2016年10月12日
 *
 */
@Service
@Transactional
public class MedicalAidService {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(MedicalAidService.class);

    /**
     * medicalAidMapper
     */
    @Autowired
    private MedicalAidMapper medicalAidMapper;

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
    public List<MedicalAidModel> findPage(Page page) {
        logger.debug("MedicalAidService findPage begin" + page);

        List<MedicalAidModel> result = medicalAidMapper.findPage(page);

        logger.debug("MedicalAidService findPage end" + result);

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
    public MedicalAidModel get(Long id) {
        logger.debug("MedicalAidService get begin " + id);

        MedicalAidModel result = medicalAidMapper.get(id);

        logger.debug("MedicalAidService get end" + result);

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
    @OperateLog(verb = OperateVerb.ADD, noun = "新增救助申请")
    public int add(MedicalAidModel medicalAid) {
        logger.debug("MedicalAidService add begin " + medicalAid);
        int result = medicalAidMapper.add(medicalAid);
        logger.debug("MedicalAidService add end" + result);

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
    public int updateStatue(MedicalAidModel medicalAid) {
        logger.debug("MedicalAidService updateStatue begin" + medicalAid);
        int result = medicalAidMapper.updateStatue(medicalAid);
        PetModel pet = new PetModel();
        pet.setId(new Long(medicalAid.getPetId()));
        if (medicalAid.getStatue() == 2) {
            pet.setStatue(4);
        }
        else if (medicalAid.getStatue() == 3) {
            pet.setStatue(3);
        }
        petMapper.updateStatue(pet);
        logger.debug("MedicalAidService updateStatue end" + result);
        return result;
    }

}
