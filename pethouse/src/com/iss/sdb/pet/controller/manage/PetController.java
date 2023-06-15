/**
 * PetController.java 2016年12月22日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.iss.sdb.pet.controller.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iss.sdb.commons.models.FileUpResModel;
import com.iss.sdb.pet.commons.FileUploadSupport;
import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.pojo.AjaxResponse;
import com.iss.sdb.pet.pojo.Page;
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
@RequestMapping("m/pet")
public class PetController {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(PetController.class);

    /**
     * 用户Service
     */
    @Autowired
    private PetService petService;

    /**
     * 文件上传
     */
    @Autowired
    private FileUploadSupport fileUpload;

    /**
     * 宠物列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/all_list")
    public ModelAndView allList() {

        logger.debug("PetController allList begin");

        ModelAndView mv = new ModelAndView("mng/pet/all_list");
        return mv;
    }

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

        logger.debug("PetController list begin");

        ModelAndView mv = new ModelAndView("mng/pet/pet_list");
        return mv;
    }

    /**
     * 待医治宠物列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/wcure_list")
    public ModelAndView wcureList() {

        logger.debug("PetController wcureList begin");

        ModelAndView mv = new ModelAndView("mng/pet/wcure_list");
        return mv;
    }
    
    /**
     * 待医治宠物列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/cureing_list")
    public ModelAndView cureingList() {

        logger.debug("PetController cureingList begin");

        ModelAndView mv = new ModelAndView("mng/pet/cureing_list");
        return mv;
    }

    /**
     * 待医治宠物列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/cure_list")
    public ModelAndView cureList() {

        logger.debug("PetController cureList begin");

        ModelAndView mv = new ModelAndView("mng/pet/cure_list");
        return mv;
    }

    /**
     * 待医治宠物列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/nocure_list")
    public ModelAndView noCureList() {

        logger.debug("PetController noCureList begin");

        ModelAndView mv = new ModelAndView("mng/pet/nocure_list");
        return mv;
    }

    /**
     * 宠物列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2017年10月25日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/adopt_list")
    public ModelAndView adoptList() {

        logger.debug("PetController adoptList begin");

        ModelAndView mv = new ModelAndView("mng/pet/adopt_list");
        return mv;
    }

    /**
     * 宠物列表页
     * <p>
     * GET / pet / list
     *
     * @author hqsunc
     * @return
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/adopted_list")
    public ModelAndView adoptedList() {

        logger.debug("PetController adoptedList begin");

        ModelAndView mv = new ModelAndView("mng/pet/adopted_list");
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
        logger.debug("PetController add begin");

        ModelAndView mv = new ModelAndView("mng/pet/pet_add");
        mv.addObject("pet", new PetModel());
        return mv;
    }

    /**
     * 根据用户ID查询单条数据
     * <p>
     * GET /pet /get
     *
     * @author hqsunc
     * @param id
     *            用户ID
     * @return 用户信息
     * @since 2016年11月19日
     */
    @RequestMapping(method = RequestMethod.GET, path = "/get/{id:\\d+}")
    public ModelAndView get(@PathVariable(value = "id") Long id) {
        logger.debug("PetController get begin");

        PetModel pet = petService.get(id);
        ModelAndView mv = new ModelAndView("mng/pet/pet_details");
        mv.addObject("pet", pet);
        logger.debug("PetController get end");

        return mv;
    }

    /**
     * 方法描述：跳转用户编辑页
     * <p>
     * GET / pet / edit
     *
     * @author hqsunc
     * @param id
     * @return
     * @since 2016年11月18日
     */

    @RequestMapping(method = RequestMethod.GET, path = "/edit/{id:\\d+}")
    public ModelAndView edit(@PathVariable(value = "id") Long id) {

        logger.debug("PetController edit begin");

        PetModel pet = petService.get(id);
        ModelAndView mv = new ModelAndView("mng/pet/pet_edit");
        mv.addObject("pet", pet);

        return null != pet ? mv : this.list();
    }

    /**
     * 方法描述：添加用户信息
     * <p>
     * POST / pet / create
     *
     * @author hqsunc
     * @param pet
     *            用户信息模型
     * @param petSession.
     *            用户会话数据
     * @return 持久化操作码
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.POST, path = "/create")
    @ResponseBody
    public String add(PetModel pet) {
        logger.debug("PetController add begin" + pet);

        String aj;
        int result = petService.add(pet);
        if (result > 0) {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }
        else {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }

        logger.debug("PetController add end " + aj);

        return aj;

    }

    /**
     * 方法描述：删除用户信息
     * <p>
     * POST / pet / delete
     *
     * @author hqsunc
     * @param pet
     *            用户模型
     * @return 持久化操作码
     * @since 2016年11月18日
     */
    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    @ResponseBody
    public String delete(PetModel pet) {

        logger.debug("PetController delete begin" + pet);

        String aj;

        int result = petService.delete(pet);
        if (result > 0) {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }
        else {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }
        logger.debug("PetController delete end" + aj);

        return aj;

    }

    /**
     * 方法描述：更新用户信息
     * <p>
     * POST / pet/update
     *
     * @author hqsunc
     * @param pet
     * @return
     * @since 2016年11月18日
     * @see
     */
    @RequestMapping(method = RequestMethod.POST, path = "/update")
    @ResponseBody
    public String update(PetModel pet) {
        logger.debug("PetController update begin" + pet);

        String aj;
        int result = petService.update(pet);
        if (result > 0) {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }
        else {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }

        logger.debug("PetController update end" + aj);

        return aj;
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
    @RequestMapping(method = RequestMethod.POST, path = "/cure")
    @ResponseBody
    public String cure(PetModel pet) {
        logger.debug("PetController cure begin" + pet);
        pet.setStatue(5);
        String aj;
        int result = petService.cure(pet);
        if (result > 0) {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }
        else {
            aj = AjaxResponse.fromCode(result).toJSONString();
        }

        logger.debug("PetController cure end" + aj);

        return aj;
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
    public String findPage(PetModel pet, Page page) {
        logger.debug("PetController findPage begin" + page);
        page.setSearchParam(pet);
        petService.findPage(page);
        String aj = AjaxResponse.fromData(page).toJSONString();
        logger.debug("PetController findPage end" + aj);
        return aj;

    }

    /**
     * 上传文件
     * 
     * @author hqsunc
     * @param request
     * @return
     * @throws IOException
     * @since 2016年10月18日
     * @see
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public FileUpResModel upload(HttpServletRequest request) throws IOException {
        logger.debug("[FileController.upload] begin.");
        List<FileUpResModel> res = fileUpload.lawResourceFile(request);
        logger.debug("[FileController.upload] end.");
        return res.get(0);
    }

}
