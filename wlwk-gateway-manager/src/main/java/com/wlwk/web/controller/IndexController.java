package com.wlwk.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wlwk.framework.support.BusinessException;
import com.wlwk.framework.web.controller.BaseController;

@RestController
public class IndexController extends BaseController {
    /**
     * 首页
     * 
     * @param mav
     * @return
     * @throws BusinessException
     */
    @GetMapping(path = { "/", "/index" })
    public ModelAndView user(ModelAndView mav) throws BusinessException {
        System.out.println(getAuthentication());
        mav.setViewName("index");
        return mav;
    }
}