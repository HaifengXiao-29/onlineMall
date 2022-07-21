package com.example.backend.constant.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
public class userLoginRequest implements Serializable {
  @Serial
  private static final long serialVersionUID = -6266398833474626648L;

  private String userAccount;
  private String password;

}
