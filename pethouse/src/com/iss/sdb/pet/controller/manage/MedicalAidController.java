/**
 * MedicalAidController.java 2016年12月22日
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

import com.iss.sdb.pet.models.MedicalAidModel;
import com.iss.sdb.pet.pojo.AjaxResponse;
import com.iss.sdb.pet.pojo.Page;
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
@RequestMapping("m/maid")
public class MedicalAidController {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(MedicalAidController.class);

    /**
     * 用户Service
     */
    @Autowired
    private MedicalAidService medicalAidService;

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

        logger.debug("MedicalAidController list begin");

        ModelAndView mv = new ModelAndView("mng/maid/medicalAid_list");
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
        logger.debug("MedicalAidController add begin");

        ModelAndView mv = new ModelAndView("mng/maid/medicalAid_add");
        mv.addObject("medicalAid", new MedicalAidModel());
        return mv;
    }

    /**
     * 根据用户ID查询单条数据
     * <p>
     * GET /medicalAid /get
     *
     * @author hqsunc
     * @param id
     *            用户ID
     * @return 用户信息
     * @since 2016年11月19日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/get/{id:\\d+}")
    public ModelAndView get(@PathVariable(value = "id") Long id) {
        logger.debug("MedicalAidController get begin");

        MedicalAidModel medicalAid = medicalAidService.get(id);
        ModelAndView mv = new ModelAndView("mng/maid/medicalAid_details");
        mv.addObject("medicalAid", medicalAid);
        logger.debug("MedicalAidController get end");

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
    public String findPage(MedicalAidModel medicalAid, Page page) {
        logger.debug("MedicalAidController findPage begin" + page);
        page.setSearchParam(medicalAid);
        medicalAidService.findPage(page);
        String aj = AjaxResponse.fromData(page).toJSONString();
        logger.debug("MedicalAidController findPage end" + aj);
        return aj;

    }

    
    /**
     * 
     * 审核
     *
     * @author hqsunc
     * @param medicalAid
     * @return
     * @since 2017年3月24日
     * @see
     */
    @RequestMapping(method = RequestMethod.POST, path = "/auditMedicalAid")
    @ResponseBody
    public String auditMedicalAid(MedicalAidModel medicalAid) {
        logger.debug("[MedicalAidController.auditMedicalAid] begin. medicalAid:" + medicalAid.toString());
        AjaxResponse ajax = new AjaxResponse(true);
        int count = medicalAidService.updateStatue(medicalAid);
        if (count <= 0) {
            ajax.toError();
            ajax.setMessage("领养申请审核操作失败");
        }
        logger.debug("[MngTeacherCtrl.auditTeacher] end.");
        return ajax.toJSONString();
    }

}
