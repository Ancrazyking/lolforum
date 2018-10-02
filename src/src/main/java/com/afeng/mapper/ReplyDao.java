package com.afeng.mapper;

import com.afeng.pojo.Reply;

import java.util.List;

/**
 * @author afeng
 * @date 2018/9/29 21:46
 **/
public interface ReplyDao
{
    /**
     * 插入回复
     *
     * @param reply
     * @return
     */
    int insertReply(Reply reply);

    /**
     * 获取话题的回复记录集
     *
     * @param topicId
     * @return
     */
    List<Reply> getRepliesOfTopic(Integer topicId);

    /**
     * 总回复数
     *
     * @return
     */
    int getRepliesCount(Integer topicId);

}
