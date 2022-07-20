package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.mapper.UserMapper;
import com.example.backend.model.domain.User;
import com.example.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.backend.constant.userConstant.USER_LOGIN;

/**
 * @author chuan
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-07-19 22:05:02
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
  implements UserService {
  @Resource
  private UserMapper userMapper;
  /*
  盐值，为了保证别人难以解码
  */
  private static final String SALT = "chuanxiao";

  /**
   * 用户登陆
   * @param userAccount 用户账号
   * @param password 用户密码
   * @param request  前端请求
   * @return 用户对象
   */
  @Override
  public User userLogin(String userAccount, String password, HttpServletRequest request) {
    //检验
    if (StringUtils.isAnyBlank(userAccount, password)) {
      return null;
    }
    if (userAccount.length() > 4 && userAccount.length() < 12) {
      return null;
    }
    if (password.length() < 8) {
      return null;
    }
    //账户不包含特殊字符
    String validPattern = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
    Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
    if (matcher.find()) {
      return null;
    }
    //2.加密
    String encryPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());
    //查询用户是否存在
    QueryWrapper queryWrapper = new QueryWrapper();
    queryWrapper.eq("userAccount", userAccount);
    queryWrapper.eq("password", encryPassword);
    User user = userMapper.selectOne(queryWrapper);
    //用户不存在
    if (user == null) {
      log.info("user login failed, userAccount can not match userPassword");
      return null;
    }
    //脱敏
    User safeUser = getSafeUser(user);
    //记录用户登陆态
    request.getSession().setAttribute(USER_LOGIN, safeUser);
    return safeUser;
  }

  public User getSafeUser(User user){
    if (user == null){
      return null;
    }
    User safeUser = new User();
    safeUser.setUsername(user.getUsername());
    safeUser.setUserAccount(user.getUserAccount());
    safeUser.setAvatarUrl(user.getAvatarUrl());
    safeUser.setGender(user.getGender());
    safeUser.setPhone(user.getPhone());
    safeUser.setEmail(user.getEmail());
    safeUser.setCreateTime(user.getCreateTime());
    return safeUser;
  }
}




