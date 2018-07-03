package com.example.springbootdemo1.mapper;

import com.example.springbootdemo1.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by lufei on 18/7/2.
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User>,MySqlMapper<User>{

}
