package com.afeng.service.impl;

import com.afeng.mapper.ReplyDao;
import com.afeng.pojo.Reply;
import com.afeng.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author afeng
 * @date 2018/10/2 10:09
 **/
@Service
public class ReplyServiceImpl implements ReplyService
{
    @Autowired
    private ReplyDao replyDao;


    public List<Reply> getRepliesOfTopic(Integer topicId)
    {
        return replyDao.getRepliesOfTopic(topicId);
    }

    public boolean addReply(Reply reply)
    {
        return replyDao.insertReply(reply) > 0;
    }

    public int repliesNum(Integer topicId)
    {
        return replyDao.getRepliesCount(topicId);
    }
}
