package com.example.backend;

import com.example.backend.mapper.UserMapper;
import com.example.backend.model.domain.User;
import com.example.backend.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import java.util.List;

@SpringBootTest
@MapperScan("com.example.backend.mapper")
class BackEndApplicationTests {

  @Resource
  private UserService userService;

  @Test
  public void userTest() {
    User user = new User();
    user.setUsername("ad");
    user.setUserAccount("12331223");
    user.setGender(1);
    user.setEmail("wewer");
    user.setPassword("21313123");
    userService.save(user);

  }
  @Test
  public void testSelect() {

  }
}
