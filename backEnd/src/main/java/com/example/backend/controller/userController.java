package com.example.backend.controller;

import com.example.backend.model.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {
  @PostMapping("/login")
  public User userLogin(@RequestBody ){

  }
}
