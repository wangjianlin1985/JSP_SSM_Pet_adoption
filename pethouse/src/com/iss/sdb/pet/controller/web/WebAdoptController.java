/**
 * AdoptController.java 2016年12月22日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.iss.sdb.pet.controller.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.iss.sdb.pet.commons.Constants;
import com.iss.sdb.pet.models.AdoptModel;
import com.iss.sdb.pet.models.UserModel;
import com.iss.sdb.pet.pojo.AjaxResponse;
import com.iss.sdb.pet.service.AdoptService;

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
@RequestMapping("w/adopt")
public class WebAdoptController {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(WebAdoptController.class);

    /**
     * 用户Service
     */
    @Autowired
    private AdoptService adoptService;

    /**
     * 用户列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ModelAndView list() {

        logger.debug("AdoptController list begin");

        ModelAndView mv = new ModelAndView("mng/adopt/adopt_list");
        return mv;
    }

    
    /**
     * 根据用户ID查询单条数据
     * <p>
     * GET /adopt /get
     *
     * @author hqsunc
     * @param id
     *            用户ID
     * @return 用户信息
     * @since 2016年11月19日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/get/{id:\\d+}")
    public ModelAndView get(@PathVariable(value = "id") Long id) {
        logger.debug("AdoptController get begin");

        AdoptModel adopt = adoptService.get(id);
        ModelAndView mv = new ModelAndView("mng/adopt/adopt_details");
        mv.addObject("adopt", adopt);
        logger.debug("AdoptController get end");

        return mv;
    }


    /**
     * 
     * 添加申请
     *
     * @author hqsunc
     * @param adopt
     * @return
     * @since 2017年3月28日
     * @see
     */
    @RequestMapping(method = RequestMethod.POST, path = "/create")
    @ResponseBody
    public String create(AdoptModel adopt,@SessionAttribute(Constants.Commons.SESSION_WEB_USER) UserModel userSession) {
        logger.debug("AdoptController create begin" + adopt);
        adopt.setUserId(Integer.parseInt(""+userSession.getId()));

        String aj;
        int result = adoptService.add(adopt);
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
