package com.afeng.controller;

import com.afeng.pojo.Reply;
import com.afeng.pojo.Tab;
import com.afeng.pojo.Topic;
import com.afeng.pojo.User;
import com.afeng.service.ReplyService;
import com.afeng.service.TabService;
import com.afeng.service.TopicService;
import com.afeng.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
    //log4j对象,??
    private final Log log = LogFactory.getLog(getClass());
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
        System.out.println("===================");
        System.out.println(topic);
        System.out.println("===================");

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

    /**
     * tab分类
     * 不同分类板块下相同标签的话题列表
     *
     * @param tabNameEn
     * @param session
     * @return
     */
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
        //评论(回复数)最多的话题
        List<Topic> hotestTopics = topicService.listMostCommentsTopics();


        tabIndexPage.addObject("topics", topics);
        tabIndexPage.addObject("topicsNum", topicsNum);
        tabIndexPage.addObject("usersNum", usersNum);
        tabIndexPage.addObject("tab", tab);
        tabIndexPage.addObject("user", user);
        tabIndexPage.addObject("hotestTopics", hotestTopics);
        return tabIndexPage;

    }


    /**
     * 用户发布主题
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/topic/add", method = RequestMethod.POST)
    public ModelAndView addTopic(HttpServletRequest request, HttpSession session)
    {
        ModelAndView homePage;
        //未登录,如果用户直接在浏览器地址栏输入/topic/add则重定向到登录页面
        if (session.getAttribute("userId") == null)
        {
            homePage = new ModelAndView("redirect:/login");
            return homePage;
        }

        //处理传入的参数
        Integer userId = (Integer) session.getAttribute("userId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Byte tabId = Byte.parseByte(request.getParameter("tab"));


        //新建主题POJO
        Topic topic = new Topic();
        topic.setUser_id(userId);
        topic.setTitle(title);
        topic.setContent(content);
        topic.setTab_id(tabId);
        topic.setCreate_time(new Date());
        topic.setUpdate_time(new Date());


        //添加一条话题
        boolean resultT = topicService.addTopic(topic);
        //用户发布一条话题则该用户的积分+1
        boolean resultC = userService.addCredit(1, userId);

        if (resultT)
        {
            if (log.isInfoEnabled())
            {
                log.info("添加主题成功!");
            }
        }

        homePage = new ModelAndView("redirect:/");
        return homePage;
    }

}
