package com.example.springbootdemo1.controller;

import com.example.springbootdemo1.Person;
import com.example.springbootdemo1.domain.User;
import com.example.springbootdemo1.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lufei on 18/7/2.
 */
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String hello(){
        return "hello springboot";
    }

    @RequestMapping("/a")
    public String testBindProperties(){
        return person.toString();
    }

    @RequestMapping("/test1")
    public int test1(){
        return userMapper.selectAll().size();
    }

    @RequestMapping("/test2")
    public int test2(@RequestParam("start") int start){
        Example example = new Example(User.class);
        example.setForUpdate(true);
        example.createCriteria().andGreaterThan("id", start);
        example.orderBy("id").asc();
        return userMapper.selectByExample(example).size();
    }

    @RequestMapping("/test3")
    public long test3(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize){
        PageHelper.startPage(page,pageSize);
        List<User> userList = userMapper.selectAll();
        return ((Page)userList).getTotal();
    }

}
