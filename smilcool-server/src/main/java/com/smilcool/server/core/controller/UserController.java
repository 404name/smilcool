package com.smilcool.server.core.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smilcool.server.core.pojo.dto.Result;
import com.smilcool.server.core.pojo.form.UserLoginForm;
import com.smilcool.server.core.pojo.form.UserQueryForm;
import com.smilcool.server.core.pojo.form.UserRegisterForm;
import com.smilcool.server.core.pojo.form.UserUpdateForm;
import com.smilcool.server.core.pojo.vo.UserVO;
import com.smilcool.server.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Angus
 * @date 2019/3/20
 */
@Slf4j
@Api(tags = "1.1", description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody @Valid UserLoginForm userLoginForm) {
        UserVO user = userService.login(userLoginForm);
        return Result.success(user);
    }

    @ApiOperation("用户注销")
    @PostMapping("/logout")
    public Result logout() {
        userService.logout();
        return Result.success();
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<UserVO> register(@RequestBody @Valid UserRegisterForm userRegisterForm) {
        UserVO registerUser = userService.register(userRegisterForm);
        return Result.success(registerUser);
    }

    @ApiOperation("用户列表")
    @GetMapping
    public Result<List<UserVO>> listUserVO() {
        List<UserVO> userListPage = userService.listUserVO();
        return Result.success(userListPage);
    }

    @ApiOperation(value = "用户信息", notes = "通过用户 id 获取用户信息（包括角色与权限信息）")
    @GetMapping("/{id}")
    public Result<UserVO> getUserVO(@PathVariable("id") Integer id) {
        UserVO user = userService.getUserVO(id);
        return Result.success(user);
    }

    @ApiOperation("用户更新")
    @PutMapping
    public Result<UserVO> updateUser(@RequestBody UserUpdateForm form) {
        UserVO user = userService.updateUser(form);
        return Result.success(user);
    }

    @ApiOperation("用户列表（分页条件查询）")
    @GetMapping("/page")
    public Result<Page<UserVO>> pageUserVO(Page page, UserQueryForm userQueryForm) {
        Page<UserVO> userListPage = userService.pageUserVO(page, userQueryForm);
        return Result.success(userListPage);
    }
}
