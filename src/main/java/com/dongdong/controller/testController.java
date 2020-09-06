package com.dongdong.controller;

import com.dongdong.annotation.ResponseBody;
import com.dongdong.annotation.ResponseResultBody;
import com.dongdong.common.Result;
import com.dongdong.common.ResultStatus;
import com.dongdong.exception.ResultException;
import com.dongdong.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @program: httpcode
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-09-05 11:32
 **/
@RestController
@RequestMapping("api/v1")
@ResponseBody  //advice  响应体方式
public class testController {
    @Autowired
    RedisUtils redisUtils;
    @GetMapping("/test")
    public Result<HashMap<Object, Object>> test() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name","dong");
        return Result.success(map);
    }

    @GetMapping("/test1")
    @ResponseResultBody //aop 响应体方式
    public Object test1() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name","dong");
        return map;
    }

    @GetMapping("/test2")
    public HashMap<Object, Object> test2() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name","dong");
        return map;
    }

    @GetMapping("/redis")
    public Result<Void> redis() {
        redisUtils.set("ceshi","1111",10);
        return Result.success();
    }
    @GetMapping("/exception")
    public HashMap<Object, Object> exce() throws ResultException {

      throw new ResultException(ResultStatus.BAD_REQUEST,"cuowu");


    }
}
