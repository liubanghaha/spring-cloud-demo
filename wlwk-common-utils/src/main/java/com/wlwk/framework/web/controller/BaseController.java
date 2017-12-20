package com.wlwk.framework.web.controller;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.wlwk.framework.domain.AjaxReturn;
import com.wlwk.framework.support.BusinessException;
import com.wlwk.framework.utils.StringUtils;
import com.wlwk.framework.web.support.binder.DateEditor;
import com.wlwk.framework.web.support.binder.DoubleEditor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Slf4j
public abstract class BaseController {

    protected @Autowired
    MessageSource messageSource;

    protected @Value("${url.resources.cdn:}")
    String resources_cdn;

    protected @Value("${url.resources.attachment:}")
    String resources_attachment;

    @ModelAttribute
    public void _init(ModelAndView mav) throws BusinessException {
        mav.addObject("dnss", Arrays.asList(resources_cdn, resources_attachment));
        mav.addObject("cdn", resources_cdn);
        mav.addObject("attachment", resources_attachment);
    }

    /**
     * 获取登录用户信息，如果用户没有登录，则返回0
     *
     * @return
     * @throws BusinessException
     */
    public String getAuthentication() throws BusinessException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && StringUtils.isNotBlank(authentication.getName()) && !authentication.getName().equals("anonymousUser")) {
            return authentication.getName();
        }
        return "0";
    }

    /**
     * 时间类型绑定
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.registerCustomEditor(Float.class, new DoubleEditor());
        binder.registerCustomEditor(Double.class, new DoubleEditor());
    }

    /**
     * 异常页面控制
     *
     * @param throwable
     * @param request
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public ModelAndView runtimeExceptionHandler(Throwable throwable, WebRequest request) {
        FastJsonJsonView jsonView = new FastJsonJsonView();
        if (throwable instanceof BusinessException) {
            jsonView.addStaticAttribute("code", ((BusinessException) throwable).getCode());
            jsonView.addStaticAttribute("info", getMessage(((BusinessException) throwable).getInfo(), ((BusinessException) throwable).getParam()));
        } else if (throwable instanceof BindException) {
            jsonView.addStaticAttribute("code", 501);
            StringBuffer errorMessage = new StringBuffer();
            List<FieldError> fieldErrors = ((BindException) throwable).getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorMessage.append(fieldError.getField());
                errorMessage.append("-");
                errorMessage.append(fieldError.getDefaultMessage());
                errorMessage.append(" ");
            }
            jsonView.addStaticAttribute("info", errorMessage);
        } else if (throwable instanceof IllegalArgumentException) {
            jsonView.addStaticAttribute("code", 501);
            jsonView.addStaticAttribute("info", throwable.getMessage());
        } else {
            jsonView.addStaticAttribute("code", 501);
            jsonView.addStaticAttribute("info", getMessage("action.info.error"));
        }
        if (log.isErrorEnabled()) {
            log.error("服务器异常", throwable);
        }
        return new ModelAndView(jsonView);
    }

    /**
     * 获取国际化资源
     *
     * @param code
     * @return
     */
    public String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    /**
     * 获取国际化资源
     *
     * @param key   配置文件中key
     * @param param 占位符
     * @return String
     */
    public String getMessage(String key, Object[] param) {
        return messageSource.getMessage(key, param, LocaleContextHolder.getLocale());
    }

    public <T> AjaxReturn pageReturn(Collection<T> data) {
        Map<String, Collection<T>> map = new HashMap<String, Collection<T>>();
        map.put("rows", data);
        return AjaxReturn.builder().code(200).info("").data(map).build();
    }

    protected ResponseEntity<byte[]> getResponseEntity(byte[] data, String fileName) throws UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"), "ISO8859-1")); // 解决文件名中文乱码问题
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
