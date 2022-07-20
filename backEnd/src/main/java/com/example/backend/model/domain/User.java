package com.example.backend.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * id

     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * username

     */
    private String username;

    /**
     * account

     */
    private String userAccount;

    /**
     * avatar

     */
    private String avatarUrl;

    /**
     * gender

     */
    private Integer gender;

    /**
     * password
     */
    private String password;

    /**
     * phone

     */
    private String phone;

    /**
     * emial
     */
    private String email;

    /**
     * createTime

     */
    private Date createTime;

    /**
     * isDelete
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
