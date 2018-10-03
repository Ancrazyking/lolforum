package com.afeng.controller;

import com.afeng.pojo.Tab;
import com.afeng.service.ReplyService;
import com.afeng.service.TabService;
import com.afeng.service.TopicService;
import com.afeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 主控制类
 *
 * @author afeng
 * @date 2018/10/2 10:48
 **/
@Controller
public class MainController
{
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private TabService tabService;



    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login()
    {
        ModelAndView loginPage = new ModelAndView("login");

        //用于获取统计信息 footer.jsp
        int topicsNum = topicService.getTopicsNum();
        int usersNum = userService.totalUserCount();

        loginPage.addObject("topicsNum", topicsNum);
        loginPage.addObject("usersNum", usersNum);
        return loginPage;
    }


    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register()
    {
        ModelAndView registerPage = new ModelAndView("register");

        //用于获取统计信息 footer.jsp
        int topicsNum = topicService.getTopicsNum();
        int usersNum = userService.totalUserCount();

        registerPage.addObject("topicsNum", topicsNum);
        registerPage.addObject("usersNum", usersNum);
        return registerPage;
    }

    /**
     * 配置404页面
     *
     * @return
     */
    @RequestMapping("/*")
    public String notFound()
    {
        return "404";
    }


    /**
     * 创建新主题指向页面
     *
     * @return
     */
    @RequestMapping("/new")
    public ModelAndView newTopic()
    {
        ModelAndView newTopicPage = new ModelAndView("newtopic");
        List<Tab> tabs = tabService.selectAllTabs();

        //用于获取统计信息 footer.jsp
        int topicsNum = topicService.getTopicsNum();
        int usersNum = userService.totalUserCount();

        /**
         * jsp页面动态显示
         */
        newTopicPage.addObject("tabs", tabs);
        newTopicPage.addObject("topicsNum", topicsNum);
        newTopicPage.addObject("usersNum", usersNum);
        return newTopicPage;

    }



}
