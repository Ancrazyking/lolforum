package com.afeng.controller;

import com.afeng.pojo.Reply;
import com.afeng.pojo.Tab;
import com.afeng.pojo.Topic;
import com.afeng.pojo.User;
import com.afeng.service.ReplyService;
import com.afeng.service.TabService;
import com.afeng.service.TopicService;
import com.afeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 话题控制类
 *
 * @author afeng
 * @date 2018/10/2 11:41
 **/
@Controller
public class TopicController
{
    @Autowired
    private TopicService topicService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UserService userService;
    @Autowired
    private TabService tabService;

    /**
     * 请求映射,默认访问的是主页
     * <p>
     * <p>
     * Web项目主页,/
     *
     * @param session
     * @return
     */
    @RequestMapping("/")
    public ModelAndView mainPage(HttpSession session)
    {
        ModelAndView indexPage = new ModelAndView("homepage");
        //获取全部的主题和用户信息
        List<Topic> topics = topicService.listTopicsAndUsers();

        int topicsNum = topicService.getTopicsNum();
        int usersNum = userService.totalUserCount();


        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getUserById(userId);

        //最热主题
        List<Topic> hotestTopics = topicService.listMostCommentsTopics();

        indexPage.addObject("topics", topics);
        indexPage.addObject("hotestTopics", hotestTopics);
        indexPage.addObject("topicsNum", topicsNum);
        indexPage.addObject("usersNum", usersNum);
        indexPage.addObject("user", user);
        return indexPage;
    }


    /**
     * 点击话题进入详情页面
     *
     * @param id      话题id
     * @param session
     * @return
     */

    @RequestMapping("/topic/{id}")
    public ModelAndView topicPage(@PathVariable("id") Integer id, HttpSession session)
    {
        //该话题的点击量+1
        boolean click = topicService.clickAddOne(id);
        //该话题的详情

        Topic topic = topicService.selectById(id);
        //该话题的全部评论
        List<Reply> replies = replyService.getRepliesOfTopic(id);
        //获取所有的评论数
        int repliesNum = replyService.repliesNum(id);
        //获取所有话题数和所有用户数
        int topicsNum = topicService.getTopicsNum();
        int usersNum = userService.totalUserCount();
        //获取用户信息
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getUserById(userId);

        //最热主题查询
        List<Topic> hotestTopics = topicService.listMostCommentsTopics();


        //渲染视图
        ModelAndView topicPage = new ModelAndView("topicpage");


        topicPage.addObject("topic", topic);
        topicPage.addObject("replies", replies);
        topicPage.addObject("repliesNum", repliesNum);
        topicPage.addObject("topicsNum", topicsNum);
        topicPage.addObject("usersNum", usersNum);
        topicPage.addObject("user", user);
        topicPage.addObject("hotestTopics", hotestTopics);
        return topicPage;

    }


    @RequestMapping("/tab/{tabNameEn}")
    public ModelAndView tabPage(@PathVariable("tabNameEn") String tabNameEn, HttpSession session)
    {
        /**
         * 通过传入的tabNameEn参数获取Tab对象
         */
        Tab tab = tabService.selectByTabNameEn(tabNameEn);
        Integer tabId = tab.getId();


        ModelAndView tabIndexPage = new ModelAndView("homepage");

        //全部主题
        List<Topic> topics = topicService.listTopicsAndUserOfTab(tabId);

        //获取统计信息
        int topicsNum = topicService.getTopicsNum();
        int usersNum = userService.totalUserCount();

        //获取用户信息
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getUserById(userId);


        //最热主题
        List<Topic> hotestTopics = topicService.listMostCommentsTopics();


        tabIndexPage.addObject("topics", topics);
        tabIndexPage.addObject("topicsNum", topicsNum);
        tabIndexPage.addObject("usersNum", usersNum);
        tabIndexPage.addObject("tab", tab);
        tabIndexPage.addObject("user", user);
        tabIndexPage.addObject("hotestTopics", hotestTopics);
        return tabIndexPage;


    }


}
