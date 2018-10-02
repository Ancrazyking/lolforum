package com.afeng.pojo;

import java.util.Date;

/**
 * 登录日志实体类
 *
 * @author afeng
 * @date 2018/9/29 20:46
 **/
public class LoginLog extends BasePojo
{
    private long id;
    private Integer user_id;
    private Date login_time;
    private String ip;
    private String device;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public Date getLogin_time()
    {
        return login_time;
    }

    public void setLogin_time(Date login_time)
    {
        this.login_time = login_time;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDevice()
    {
        return device;
    }

    public void setDevice(String device)
    {
        this.device = device == null ? null : device.trim();
    }
}
