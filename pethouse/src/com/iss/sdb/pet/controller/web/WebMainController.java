/**
 * RoleController.java 2016年9月19日
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.iss.sdb.pet.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iss.sdb.commons.utils.EncryptUtil;
import com.iss.sdb.pet.commons.Constants;
import com.iss.sdb.pet.models.PetModel;
import com.iss.sdb.pet.models.UserModel;
import com.iss.sdb.pet.pojo.AjaxResponse;
import com.iss.sdb.pet.service.PetService;
import com.iss.sdb.pet.service.UserService;

/**
 * WebMainController
 * 
 * @author hqsunc
 * @since 2016年10月12日
 *
 */
@Controller
@RequestMapping("/w")
public class WebMainController {

    private Log logger = LogFactory.getLog(WebMainController.class);

    @Autowired
    private PetService petService;

    @Autowired
    private UserService userService;

    /**
     * 跳转的主页
     * 
     * @author hqsunc
     * @return
     * @since 2016年10月17日
     * @see
     */
    @RequestMapping(path = "/index")
    public ModelAndView init() {
        ModelAndView mv = new ModelAndView("web/index");

        PetModel pet = new PetModel();
        List<PetModel> list = petService.findList(pet);
        mv.addObject("petList", list);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    @ResponseBody
    public String login(String userName, String password, String code, HttpSession session, HttpServletRequest request,
            HttpServletResponse response) {
        AjaxResponse ajax = new AjaxResponse(true);
        UserModel user=new UserModel();
        user.setPassword(EncryptUtil.md5(password));
        user.setUserName(userName);
        UserModel userModel = userService.getUser(user);
        if (userModel != null && userModel.getPassword().equals(user.getPassword())) {
            if (userModel.getRole() != 3) {
                ajax.setMessage("该用户为管理员或 医护人员");
                ajax.toError();
            }
            else {
                session.setAttribute(Constants.Commons.SESSION_WEB_USER, userModel);
                ajax.toSuccess();
            }

        }
        else {
            ajax.setMessage("用户名或密码错误");
            ajax.toError();
        }
        logger.debug("WebMainController login end" + user);
        return AjaxResponse.fromData(ajax).toJSONString();
    }
    
    @RequestMapping(path = "/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute(Constants.Commons.SESSION_WEB_USER);
        ModelAndView mv = new ModelAndView("web/index");
        PetModel pet = new PetModel();
        List<PetModel> list = petService.findList(pet);
        mv.addObject("petList", list);
        return mv;
    }

    /**
     * 关于我们
     * 
     * @author hqsunc
     * @return
     * @since 2017年1月19日
     * @see
     */
    @RequestMapping(path = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("web/about");
        return mv;
    }

    /**
     * 跳转的主页
     * 
     * @author hqsunc
     * @return
     * @since 2016年10月17日
     * @see
     */
    @RequestMapping(path = "/desktop")
    public ModelAndView desktop() {
        return new ModelAndView("web/desktop");
    }
}
