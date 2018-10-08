package com.afeng.controller;

import com.afeng.pojo.LoginLog;
import com.afeng.pojo.Topic;
import com.afeng.pojo.User;
import com.afeng.service.LoginLogService;
import com.afeng.service.TopicService;
import com.afeng.service.UserService;
import com.afeng.utils.MD5Utils;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.List;

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


    /**
     * 用户注册
     *
     * @param request
     * @return
     */
    @RequestMapping("/user/register")
    public String register(HttpServletRequest request)
    {
        //User  POJO
        User user = new User();
        //处理传入的参数
        String phoneNum = request.getParameter("tel");
        String areaCode = request.getParameter("areaCode");
        String phone = areaCode + phoneNum;
        Byte type = new Byte("0");
        //md5加密用户密码
        String password = MD5Utils.getMD5(request.getParameter("password"));
        //生成随机数用于生成随机头像
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;
        String avatarUrl = "/static/img/avatar-default-" + randomNum + ".png";

        user.setUsername(request.getParameter("username"));
        user.setPassword(password);
        user.setEmail(request.getParameter("email"));
        user.setPhone_num(phone);
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());
        user.setCredit(0);
        user.setType(type);
        user.setAvatar(avatarUrl);
        boolean registerResult = userService.addUser(user);
        System.out.println(user);
        return "redirect:/";
    }


    /**
     * 用户登录
     *
     * @param request
     * @param session
     * @return 0:用户名不存在 1.密码错误 2:登录成功
     */
    @RequestMapping("/user/login")
    @ResponseBody
    public Object login(HttpServletRequest request, HttpSession session)
    {
        //接收传入的参数
        String username = request.getParameter("username");
        System.out.println(request.getParameter("password"));
        String password = MD5Utils.getMD5(request.getParameter("password"));

        //验证用户名和密码
        int loginResult = userService.login(username, password);

        HashMap<String, String> result = new HashMap<String, String>();


        //2表示登录成功
        if (loginResult == 2)
        {
            User user = userService.getUserByUsername(username);
            Integer userId = user.getId();
            //用户登录成功添加积分
            boolean addCredit = userService.addCredit(1, userId);

            //将用户信息保存到会话中,即Session中
            session.setAttribute("userId", userId);
            session.setAttribute("username", username);

            //获取登录的信息
            String ip = getRemoteIP(request);
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            //获取用户的浏览器名
            String userBrowser = userAgent.getBrowser().toString();

            //写入到登录日志
            LoginLog log = new LoginLog();
            log.setDevice(userBrowser);
            log.setIp(ip);
            log.setUser_id(userId);
            log.setLogin_time(new Date());
            boolean addLog = loginLogService.addLoginLog(log);
            result.put("stateCode", "2");
        } else if (loginResult == 1)
        {
            result.put("stateCode", "1");
        } else
        {
            result.put("stateCode", "0");
        }

        return result;
    }

    /**
     * 用户注销
     *
     * @param session
     * @return
     */
    @RequestMapping("/user/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("userId");
        session.removeAttribute("username");
        return "redirect:/";
    }


    /**
     * 获取客户端IP
     *
     * @param request
     * @return
     */
    public String getRemoteIP(HttpServletRequest request)
    {
        if (request.getHeader("x-forwarded-for") == null)
        {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }


    /**
     * 用户主页
     *
     * @param username
     * @param session
     * @return
     */
    @RequestMapping("/user/{username}")
    public ModelAndView userHomePage(@PathVariable("username") String username, HttpSession session)
    {

        boolean ifExistUser = userService.existUsername(username);

        //获取统计信息
        int topicsNum = topicService.getTopicsNum();
        int usersNum = userService.totalUserCount();


        //获取用户的信息
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getUserById(userId);

        //最热主题
        List<Topic> hotestTopics = topicService.listMostCommentsTopics();

        ModelAndView userHomePage = new ModelAndView("userhomepage");
        userHomePage.addObject("hotestTopics", hotestTopics);
        if (ifExistUser)
        {
            User resultUser = userService.getUserByUsername(username);
            userHomePage.addObject("userInfo", resultUser);
            userHomePage.addObject("topicsNum", topicsNum);
            userHomePage.addObject("usersNum", usersNum);
            userHomePage.addObject("user", user);
            return userHomePage;


        } else
        {
            String errorInfo = "该用户未找到!";
            userHomePage.addObject("errorInfo", errorInfo);
            return userHomePage;
        }
    }

    /**
     * 用户设置
     *
     * @param session
     * @return
     */
    @RequestMapping("/user/settings")
    public ModelAndView userSettings(HttpSession session)
    {
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getUserById(userId);

        //获取最热主题
        List<Topic> hotestTopics = topicService.listMostCommentsTopics();


        ModelAndView userSettings = new ModelAndView("usersettings");

        userSettings.addObject("user", user);
        userSettings.addObject("hotestTopics", hotestTopics);
        return userSettings;
    }

    /**
     * 用户设置点击更换头像按钮头像
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/settings/avatar", method = RequestMethod.GET)
    public ModelAndView userSettingsAvatar(HttpSession session)
    {
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getUserById(userId);

        //最热主题
        List<Topic> hotestTopics = topicService.listMostCommentsTopics();

        ModelAndView userUpdateAvatar = new ModelAndView("userupdateavatar");
        userUpdateAvatar.addObject("user", user);
        userUpdateAvatar.addObject("hotestTopics", hotestTopics);
        return userUpdateAvatar;
    }


    /**
     * 用户设置头像更新
     * 文件上传
     *
     * @param avatarFile
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/settings/avatar/update", method = RequestMethod.POST)
    public ModelAndView userUpdateAvatar(@RequestPart("avatar") MultipartFile avatarFile, HttpSession session)
    {

        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getUserById(userId);

        String fileName = avatarFile.getOriginalFilename();
        System.out.println(fileName);
        //得到文件的后缀名
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        //建立时间戳
        Long date = new Date().getTime();
        //设置新的文件名
        String newFileName = date + "-" + userId + "." + suffix;
        String absolutePath = session.getServletContext().getRealPath("/static/img/avatar") + "/" + newFileName;
        String relativePath = "/img/avatar" + "/" + newFileName;
        System.out.println(relativePath);
        User u = new User();
        u.setAvatar(relativePath);
        u.setId(userId);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setCredit(user.getCredit());
        u.setType(user.getType());
        u.setPhone_num(user.getPhone_num());
        u.setCreate_time(user.getCreate_time());
        u.setUpdate_time(new Date());

        //文件上传的绝对路径
        /// static/img/avatar
        File file = new File(absolutePath);

        //上传文件
        if (!file.exists())
        {
            try
            {
                avatarFile.transferTo(file);
                userService.updateUser(u);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        //最热主题
        List<Topic> hotestTopics = topicService.listMostCommentsTopics();

        ModelAndView userUpdateAvatar = new ModelAndView("userupdateavatar");
        userUpdateAvatar.addObject("user", user);
        userUpdateAvatar.addObject("hotestTopics", hotestTopics);
        return userUpdateAvatar;

    }


}
