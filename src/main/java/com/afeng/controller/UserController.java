package com.afeng.controller;

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



}
