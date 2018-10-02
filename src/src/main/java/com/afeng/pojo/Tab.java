package com.afeng.pojo;

import java.util.List;

/**
 * 标签实体类,话题的分类
 *
 * @author afeng
 * @date 2018/9/29 10:25
 **/
public class Tab extends BasePojo
{
    private Integer id;
    private String tab_name;
    private String tab_name_en;

    //话题标签分类表需要对应话题的集合
    private List<Topic> topicsList;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTab_name()
    {
        return tab_name;
    }

    public void setTab_name(String tab_name)
    {
        this.tab_name = tab_name;
    }

    public String getTab_name_en()
    {
        return tab_name_en;
    }

    public void setTab_name_en(String tab_name_en)
    {
        this.tab_name_en = tab_name_en;
    }


    public List<Topic> getTopicsList()
    {
        return topicsList;
    }

    public void setTopicsList(List<Topic> topicsList)
    {
        this.topicsList = topicsList;
    }
}
