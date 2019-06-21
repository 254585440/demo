package com.example.service;

import com.example.entity.userInfo;
import com.example.mapper.userInfoMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userServiceImpl implements userService{

    public static final String USER = "user:";

    @Autowired
    private userInfoMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    public int adduser(userInfo user){
        int i = userMapper.insert(user);
        return i;
    }

    @Override
    public List<userInfo> selectAll() {
        List<userInfo> list = userMapper.getAll();
        return list;
    }

    @Override
    public userInfo selectById(int id) {
        String key = USER + id;
        if(redisUtil.hasKey(key)){
            userInfo userI = (userInfo) redisUtil.get(key);
            System.out.println("从缓存中获取user");
            return userI;
        }
        //从数据库中查询然后放入redis中
        userInfo userI = userMapper.selectById(id);
        redisUtil.set(key,userI);
        return userI;
    }
}
