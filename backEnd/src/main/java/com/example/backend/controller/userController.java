package com.example.backend.controller;

import com.example.backend.constant.request.userLoginRequest;
import com.example.backend.model.domain.User;
import com.example.backend.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class userController {
  @Resource
  private UserService userService;
  @PostMapping("/login")
  public User userLogin(@RequestBody userLoginRequest userLoginRequest, HttpServletRequest request){
    if (userLoginRequest == null){
      return null;
    }
    String userAccount = userLoginRequest.getUserAccount();
    String password = userLoginRequest.getPassword();
    if(StringUtils.isAnyBlank(userAccount,password)){
      return null;
    }
    return userService.userLogin(userAccount,password,request);
  }
}
