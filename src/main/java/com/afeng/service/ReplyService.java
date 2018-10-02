package com.afeng.service;

import com.afeng.pojo.Reply;

import java.util.List;

/**
 * @author afeng
 * @date 2018/9/29 21:53
 **/
public interface ReplyService
{
    /**
     * 获取一个话题的总回复数
     *
     * @param topicId
     * @return
     */
    List<Reply> getRepliesOfTopic(Integer topicId);

    /**
     * 新增一条回复
     *
     * @param reply
     * @return
     */
    boolean addReply(Reply reply);

    /**
     * 一个话题的总回复数
     *
     * @param topicId
     * @return
     */
    int repliesNum(Integer topicId);


}
