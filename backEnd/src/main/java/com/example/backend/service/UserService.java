package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.model.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author chuan
* @description 针对表【user】的数据库操作Service
* @createDate 2022-07-19 22:05:02
*/
public interface UserService extends IService<User> {

    User userLogin(String userAccount, String password, HttpServletRequest request);

    User getSafeUser(User user);
}
