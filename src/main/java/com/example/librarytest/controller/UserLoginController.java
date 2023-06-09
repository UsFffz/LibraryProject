package com.example.librarytest.controller;

import com.example.librarytest.pojo.dto.UserLoginDTO;
import com.example.librarytest.service.LoginService;
import com.example.librarytest.web.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@Api(tags = "用户中心")
@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public JsonResult<String> userLogin(UserLoginDTO userLoginDTO, HttpServletRequest httpServletRequest){
        String jwt =  loginService.userLoginService(userLoginDTO);
        return JsonResult.ok(jwt);
    }

}
