package com.wlwk.manager.web.controller;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wlwk.framework.domain.AjaxReturn;
import com.wlwk.framework.domain.Pagination;
import com.wlwk.framework.support.BusinessException;
import com.wlwk.framework.web.controller.BaseController;
import com.wlwk.framework.web.support.annotation.Secure;
import com.wlwk.manager.domain.UserAccount;
import com.wlwk.manager.service.IDemoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoController extends BaseController {
    private @Autowired(required = false)
    IDemoService demoService;

    /**
     * 查询用户账号
     *
     * @return
     * @throws BusinessException
     */

    @ApiOperation(value = "查询用户账号", notes = "查询用户账号", code = 200, produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功", response = UserAccount.class)})
    @PostMapping(path = {"/manager-find-user-account"})
    public AjaxReturn findUserAccount() throws BusinessException {
        String userId = getAuthentication();

        UserAccount account = demoService.findUserAccount(userId);

        return new AjaxReturn(200, null, account);
    }

    /**
     * 添加用户账号
     *
     * @return
     * @throws BusinessException
     */
    @ApiOperation(value = "添加用户账号", notes = "添加用户账号", code = 200, produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "添加成功", response = UserAccount.class)})
    @PostMapping(path = {"/manager-add-user-account"})
    public AjaxReturn addUserAccount(//
                                     @ApiParam(name = "loginName", value = "用户名", required = true) @RequestParam(name = "loginName") String loginName, //
                                     @ApiParam(name = "loginPwd", value = "密码", required = true) @RequestParam(name = "loginPwd") String loginPwd, //
                                     @ApiParam(name = "confirmPwd", value = "确认密码", required = true) @RequestParam(name = "confirmPwd") String confirmPwd //
    ) throws BusinessException {

        if (log.isDebugEnabled()) {
            log.debug("loginName:{}", loginName);
            log.debug("loginPwd:{}", loginPwd);
            log.debug("confirmPwd:{}", confirmPwd);
        }

        String userId = getAuthentication();

        demoService.addUserAccount(userId, loginName, loginPwd, confirmPwd);

        return new AjaxReturn(200, null, null);
    }

    /**
     * 查询用户账号列表
     *
     * @return
     * @throws BusinessException
     */
    @ApiOperation(value = "查询用户账号列表", notes = "查询用户账号列表", code = 200, produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功", response = UserAccount.class)})
    @PostMapping(path = {"/manager-list-user-account"})
    public AjaxReturn listUserAccount(//
                                      @ApiParam(name = "page", value = "当前页", required = true) @RequestParam(name = "page") Integer page, //
                                      @ApiParam(name = "rows", value = "每页显示数量", required = true) @RequestParam(name = "rows") Integer rows//
    ) throws BusinessException {

        if (log.isDebugEnabled()) {
            log.debug("page:{}", page);
            log.debug("rows:{}", rows);
        }
        Validate.isTrue(page >= 1, "illegal.parameter:%s", "page");
        Validate.isTrue(rows <= 100, "illegal.parameter:%s", "rows");

        String userId = getAuthentication();

        Pagination<UserAccount> listUserAccount = demoService.listUserAccount(userId, page, rows);

        return listUserAccount;
    }

    /**
     * 跨服务调用
     *
     * @return
     * @throws BusinessException
     */
    @ApiOperation(value = "跨服务调用", notes = "跨服务调用", code = 200, produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功", response = AjaxReturn.class)})
    @PostMapping(path = {"/manager-feign-client-demo"})
    public AjaxReturn listUserAccount() throws BusinessException {

        String userId = getAuthentication();

        String str = demoService.feignClientDemo(userId);

        return new AjaxReturn(200, null, str);
    }
}
