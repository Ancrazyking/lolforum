package com.afeng.controller;

import com.afeng.pojo.Reply;
import com.afeng.service.ReplyService;
import com.afeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author afeng
 * @date 2018/10/8 15:30
 **/
@Controller
public class ReplyController
{
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UserService userService;


    /**
     * 用户回复,添加一条回复
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/reply/add", method = RequestMethod.POST)
    public ModelAndView addReply(HttpServletRequest request)
    {
        //处理传入的参数
        Integer topicId = Integer.parseInt(request.getParameter("topicId"));
        Integer replyUserId = Integer.parseInt(request.getParameter("replyUserId"));
        String content = request.getParameter("content");

        //创建Reply对象
        Reply reply = new Reply();
        reply.setTopic_id(topicId);
        reply.setReply_user_id(replyUserId);
        reply.setContent(content);
        reply.setCreate_time(new Date());
        reply.setUpdate_time(new Date());

        //数据库插入一条回复记录
        boolean ifSuccess = replyService.addReply(reply);

        //用户发帖会增加积分
        boolean ifSucAddCredit = userService.addCredit(1, replyUserId);

        ModelAndView topicpage = new ModelAndView("redirect:/topic/" + topicId);
        return topicpage;

    }


}
