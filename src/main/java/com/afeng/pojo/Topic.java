package com.afeng.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author afeng
 * @date 2018/9/29 10:27
 * <p>
 * <p>
 * <p>
 * 话题实体表
 **/
public class Topic extends BasePojo
{
    //主题关联的用户
    private User user;

    //主题关联的标签
    private Tab tab;

    //主题的总回复数
    private Integer totalReplies;


    private Integer id;
    private Integer user_id;
    private Date create_time;
    private Date update_time;
    private String title;
    private String content;
    //点击次数
    private Integer click;
    //关联的标签id
    private Byte tab_id;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Tab getTab()
    {
        return tab;
    }

    public void setTab(Tab tab)
    {
        this.tab = tab;
    }

    public Integer getTotalReplies()
    {
        return totalReplies;
    }

    public void setTotalReplies(Integer totalReplies)
    {
        this.totalReplies = totalReplies;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUser_id()
    {
        return user_id;
    }

    public void setUser_id(Integer user_id)
    {
        this.user_id = user_id;
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title == null ? null : title.trim();
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }

    public Integer getClick()
    {
        return click;
    }

    public void setClick(Integer click)
    {
        this.click = click;
    }

    public Byte getTab_id()
    {
        return tab_id;
    }

    public void setTab_id(Byte tab_id)
    {
        this.tab_id = tab_id;
    }


    public String getFormatCreateTime()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = simpleDateFormat.format(this.create_time);
        return date;
    }

    public String getFormatUpdateTime()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = simpleDateFormat.format(this.update_time);
        return date;

    }
}
