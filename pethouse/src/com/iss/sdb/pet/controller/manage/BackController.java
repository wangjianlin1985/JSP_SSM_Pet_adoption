/**
 * BackController.java 2016年12月22日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.iss.sdb.pet.controller.manage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iss.sdb.pet.models.BackModel;
import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.pojo.AjaxResponse;
import com.iss.sdb.pet.pojo.Page;
import com.iss.sdb.pet.service.BackService;
import com.iss.sdb.pet.service.PetService;

/**
 * 
 * BackController
 * 
 * @author hqsunc
 * @since 2017年3月7日
 * @see [Class/Method]
 *
 */
@Controller
@RequestMapping("m/back")
public class BackController {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(BackController.class);

    /**
     * 用户Service
     */
    @Autowired
    private BackService backService;
    
    @Autowired
    private PetService petService;

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

        logger.debug("BackController list begin");

        ModelAndView mv = new ModelAndView("mng/back/back_list");
        return mv;
    }
    
    /**
     * 申请列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/all_list")
    public ModelAndView allList() {

        logger.debug("BackController allList begin");

        ModelAndView mv = new ModelAndView("mng/back/all_list");
        return mv;
    }
    
    /**
     * 申请列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/yes_list")
    public ModelAndView yesList() {

        logger.debug("BackController yesList begin");

        ModelAndView mv = new ModelAndView("mng/back/yes_list");
        return mv;
    }
    
    /**
     * 申请列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/no_list")
    public ModelAndView noList() {

        logger.debug("BackController noList begin");

        ModelAndView mv = new ModelAndView("mng/back/no_list");
        return mv;
    }

    /**
     * 跳转用户新增页
     * <p>
     * GET / pet / add
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public ModelAndView add() {
        logger.debug("BackController add begin");

        ModelAndView mv = new ModelAndView("mng/back/back_add");
        mv.addObject("back", new BackModel());
        return mv;
    }

    /**
     * 根据用户ID查询单条数据
     * <p>
     * GET /back /get
     *
     * @author hqsunc
     * @param id
     *            用户ID
     * @return 用户信息
     * @since 2016年11月19日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/get/{id:\\d+}")
    public ModelAndView get(@PathVariable(value = "id") Long id) {
        logger.debug("BackController get begin");

        BackModel back = backService.get(id);
        ModelAndView mv = new ModelAndView("mng/back/back_details");
        mv.addObject("back", back);
        logger.debug("BackController get end");

        return mv;
    }

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
    @RequestMapping(method = RequestMethod.POST, path = "/findPage")
    @ResponseBody
    public String findPage(BackModel back, Page page) {
        logger.debug("BackController findPage begin" + page);
        page.setSearchParam(back);
        backService.findPage(page);
        String aj = AjaxResponse.fromData(page).toJSONString();
        logger.debug("BackController findPage end" + aj);
        return aj;

    }

    
    /**
     * 
     * 审核
     *
     * @author hqsunc
     * @param back
     * @return
     * @since 2017年3月24日
     * @see
     */
    @RequestMapping(method = RequestMethod.POST, path = "/auditBack")
    @ResponseBody
    public String auditBack(BackModel back) {
        logger.debug("[BackController.auditBack] begin. back:" + back.toString());
        AjaxResponse ajax = new AjaxResponse(true);
        int count = backService.updateStatue(back);
        if (count <= 0) {            
            ajax.toError();
            ajax.setMessage("领养申请审核操作失败");
        }
        logger.debug("[MngTeacherCtrl.auditTeacher] end.");
        return ajax.toJSONString();
    }

}
