package com.afeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主控制类
 *
 * @author afeng
 * @date 2018/10/2 10:48
 **/
@Controller
public class MainController
{
    @RequestMapping("/*")
    public String notFound()
    {
        return "404";
    }
}
