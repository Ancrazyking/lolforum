package com.afeng.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author afeng
 * @date 2018/9/29 10:01
 **/
public class User extends BasePojo
{
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone_num;
    private Date create_time;
    private Date update_time;
    private Integer credit;

/*    private String formatCreateTime;
    private String formatUpdateTime;*/


    //保存图片的字符串
    private String avatar;
    private Byte type;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username == null ? null : username.trim();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone_num()
    {
        return phone_num;
    }

    public void setPhone_num(String phone_num)
    {
        this.phone_num = phone_num == null ? null : phone_num.trim();
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


    public Integer getCredit()
    {
        return credit;
    }

    public void setCredit(Integer credit)
    {
        this.credit = credit;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Byte getType()
    {
        return type;
    }

    public void setType(Byte type)
    {
        this.type = type;
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
