package com.afeng.controller;

import com.afeng.pojo.LoginLog;
import com.afeng.service.LoginLogService;
import com.afeng.service.TopicService;
import com.afeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author afeng
 * @date 2018/9/29 11:18
 **/
@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private TopicService topicService;











}
