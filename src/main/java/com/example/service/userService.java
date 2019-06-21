package com.example.service;

import com.example.entity.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface userService {

    int adduser(userInfo user);

    List<userInfo> selectAll();

    userInfo selectById(int id);

}
