/**
 * MedicalAidController.java 2016年12月22日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.iss.sdb.pet.controller.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.iss.sdb.pet.commons.Constants;
import com.iss.sdb.pet.models.MedicalAidModel;
import com.iss.sdb.pet.models.UserModel;
import com.iss.sdb.pet.pojo.AjaxResponse;
import com.iss.sdb.pet.service.MedicalAidService;

/**
 * 
 * 宠物 Controller
 * 
 * @author hqsunc
 * @since 2017年3月7日
 * @see [Class/Method]
 *
 */
@Controller
@RequestMapping("w/maid")
public class WebMedicalAidController {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(WebMedicalAidController.class);

    /**
     * 用户Service
     */
    @Autowired
    private MedicalAidService medicalAidService;

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    @ResponseBody
    public String create(MedicalAidModel medicalAid,
            @SessionAttribute(Constants.Commons.SESSION_WEB_USER) UserModel userSession) {
        logger.debug("AdoptController create begin" + medicalAid);
        medicalAid.setUserId(Integer.parseInt("" + userSession.getId()));

        String aj;
        int result = medicalAidService.add(medicalAid);
        if (result > 0) {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }
        else {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }

        logger.debug("AdoptController create end " + aj);

        return aj;

    }
}
