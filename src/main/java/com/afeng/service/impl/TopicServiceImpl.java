package com.afeng.service.impl;

import com.afeng.mapper.TopicDao;
import com.afeng.pojo.Topic;
import com.afeng.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author afeng
 * @date 2018/10/2 10:08
 **/
@Service
public class TopicServiceImpl implements TopicService
{
    @Autowired
    private TopicDao topicDao;


    public List<Topic> getAllTopics()
    {
        return topicDao.selectAllTopics();
    }

    public List<Topic> listTopicsAndUsers()
    {
        return topicDao.listTopicsAndUsers();
    }

    public List<Topic> listMostCommentsTopics()
    {
        return topicDao.listMostCommentsTopics();
    }

    public List<Topic> listTopicsAndUserOfTab(Integer tabId)
    {
        return topicDao.listTopicsAndUsersOfTab(tabId);
    }

    public Topic selectById(Integer id)
    {
        return topicDao.selectTopicById(id);
    }

    public boolean addTopic(Topic topic)
    {
        return topicDao.insertTopic(topic) > 0;
    }

    public boolean clickAddOne(Integer id)
    {
        return topicDao.clickAddOne(id) > 0;
    }

    public int getTopicsNum()
    {
        return topicDao.totalTopicsCount();
    }
}
