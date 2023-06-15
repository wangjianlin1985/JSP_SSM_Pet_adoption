/**
 * PetController.java 2016年12月22日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.iss.sdb.pet.controller.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.iss.sdb.pet.commons.Constants;
import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.models.UserModel;
import com.iss.sdb.pet.pojo.AjaxResponse;
import com.iss.sdb.pet.service.PetService;

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
@RequestMapping("w/pet")
public class WebPetController {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(WebPetController.class);

    /**
     * 用户Service
     */
    @Autowired
    private PetService petService;

   
    
    
    /**
     * 方法描述：用户信息分页查询
     * <p>
     * POST / pet/findPage
     *
     * @author hqsunc
     * @param pet
     *            用户信息模型
     * @param page
     *            分页模型
     * @return 用户信息列表分袂
     * @since 2016年11月18日
     * @see
     */
    @RequestMapping(method = RequestMethod.GET, path = "/findList")
    @ResponseBody
    public String findList(@SessionAttribute(Constants.Commons.SESSION_WEB_USER) UserModel userSession) {
        logger.debug("PetController findPage begin");
        PetModel pet=new PetModel();
        pet.setAdoptId(Integer.parseInt(""+userSession.getId()));
        List<PetModel> list=petService.findList(pet);
        String aj = AjaxResponse.fromData(list).toJSONString();
        logger.debug("PetController findPage end" + aj);
        return aj;

    }

   

}
