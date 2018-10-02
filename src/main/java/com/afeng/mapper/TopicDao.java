package com.afeng.mapper;

import com.afeng.pojo.Topic;

import java.util.List;

/**
 * @author afeng
 * @date 2018/9/29 21:46
 **/
public interface TopicDao
{
    /**
     * 插入一个话题
     *
     * @param topic
     * @return
     */
    int insertTopic(Topic topic);

    /**
     * 通过话题id查询话题
     *
     * @param id
     * @return
     */
    Topic selectTopicById(Integer id);

    /**
     * 查询所有话题和用户
     *
     * @return
     */
    List<Topic> listTopicsAndUsers();

    /**
     * 通过标签查询所有话题和用户
     *
     * @param tabId
     * @return
     */
    List<Topic> listTopicsAndUsersOfTab(Integer tabId);

    /**
     * 查询最多评论数的话题列表
     *
     * @return
     */
    List<Topic> listMostCommentsTopics();

    /**
     * 获取所有话题
     *
     * @return
     */
    List<Topic> selectAllTopics();


    /**
     * 点击发布话题
     *
     * @param id
     * @return
     */
    int clickAddOne(Integer id);

    /**
     * 总话题数
     *
     * @return
     */
    int totalTopicsCount();
}
