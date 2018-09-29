package com.afeng.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 回复实体类
 *
 * @author afeng
 * @date 2018/9/29 21:40
 **/
public class Reply extends BasePojo
{
    /**
     * 管理用户
     */
    private User user;

    private Long id;
    private Integer topic_id;
    private Integer reply_user_id;
    private String content;
    private Date create_time;
    private Date update_time;
    private String device;


    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getTopic_id()
    {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id)
    {
        this.topic_id = topic_id;
    }

    public Integer getReply_user_id()
    {
        return reply_user_id;
    }

    public void setReply_user_id(Integer reply_user_id)
    {
        this.reply_user_id = reply_user_id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreate_time()
    {
        return create_time;
    }

    public void setCreate_time(Date create_time)
    {
        this.create_time = create_time;
    }

    public Date getUpdate_time()
    {
        return update_time;
    }

    public void setUpdate_time(Date update_time)
    {
        this.update_time = update_time;
    }

    public String getDevice()
    {
        return device;
    }

    public void setDevice(String device)
    {
        this.device = device == null ? null : device.trim();
    }

    public String getLocalCreateTime()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(this.create_time);
        return date;
    }

    public String getLocalUpdateTime()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(update_time);
        return date;
    }
}
