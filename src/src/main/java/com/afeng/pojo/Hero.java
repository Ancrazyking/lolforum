package com.afeng.pojo;

/**
 * @author afeng
 * @date 2018/9/28 10:30
 **/
public class Hero
{
    private int id;
    private String icon;
    private String hero_name;
    private String hero_info;
    private String hero_tags;
    private String hero_title;

    public String getHero_title()
    {
        return hero_title;
    }

    public void setHero_title(String hero_title)
    {
        this.hero_title = hero_title;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getHero_name()
    {
        return hero_name;
    }

    public void setHero_name(String hero_name)
    {
        this.hero_name = hero_name;
    }

    public String getHero_info()
    {
        return hero_info;
    }

    public void setHero_info(String hero_info)
    {
        this.hero_info = hero_info;
    }

    public String getHero_tags()
    {
        return hero_tags;
    }

    public void setHero_tags(String hero_tags)
    {
        this.hero_tags = hero_tags;
    }


    @Override
    public String toString()
    {
        return "Hero{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", hero_name='" + hero_name + '\'' +
                ", hero_info='" + hero_info + '\'' +
                ", hero_tags='" + hero_tags + '\'' +
                ", hero_title='" + hero_title + '\'' +
                '}';
    }
}
