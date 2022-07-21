package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.model.domain.User;
import org.apache.ibatis.annotations.Mapper;


/**
* @author chuan
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-07-19 23:50:47
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




