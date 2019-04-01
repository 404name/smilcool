package com.smilcool.server.core.controller;

import com.smilcool.server.common.dto.Result;
import com.smilcool.server.common.util.validation.BindingResultUtil;
import com.smilcool.server.core.pojo.form.UserRoleAddForm;
import com.smilcool.server.core.pojo.vo.UserRoleVO;
import com.smilcool.server.core.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Angus
 * @date 2019/3/29
 */
@Api(description = "用户角色接口", tags = {"1.4"})
@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation("用户角色列表")
    @GetMapping("/user-role")
    public Result<List<UserRoleVO>> list() {
        List<UserRoleVO> userRoleList = userRoleService.list();
        return Result.success(userRoleList);
    }

    @ApiOperation("用户角色添加")
    @PostMapping("/user-role")
    public Result<UserRoleVO> add(@RequestBody @Valid UserRoleAddForm userRoleAddForm,
                                  BindingResult bindingResult) {
        BindingResultUtil.validate(bindingResult);
        UserRoleVO userRole = userRoleService.add(userRoleAddForm);
        return Result.success(userRole);
    }
}
