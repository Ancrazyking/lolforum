package com.afeng.service;

import com.afeng.pojo.Topic;

import java.util.List;

/**
 * @author afeng
 * @date 2018/9/29 21:53
 **/
public interface TopicService
{
    /**
     * 获取全部的话题
     *
     * @return
     */
    List<Topic> getAllTopics();

    /**
     * 获取全部主题及用户信息,用于渲染首页
     *
     * @return
     */
    List<Topic> listTopicsAndUsers();


    /**
     * 获取最多评论主题列表
     *
     * @return
     */
    List<Topic> listMostCommentsTopics();


    /**
     * 获取不同标签的全部主题以及用户信息
     *
     * @param tabId
     * @return
     */
    List<Topic> listTopicsAndUserOfTab(Integer tabId);

    /**
     * 通过tabid获取特定的话题
     *
     * @param id
     * @return
     */
    Topic selectById(Integer id);

    /**
     * 新建主题
     *
     * @param topic
     * @return
     */
    boolean addTopic(Topic topic);

    /**
     * 话题点击量+1
     *
     * @param id
     * @return
     */
    boolean clickAddOne(Integer id);

    /**
     * 获取话题总数

     * @return
     */
    int getTopicsNum();
}
