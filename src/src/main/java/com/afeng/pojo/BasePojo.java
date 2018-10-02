package com.afeng.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 基类pojo
 * 继承该类的所有类继承他的toString()方法
 *
 * @author afeng
 * @date 2018/9/29 10:16
 **/
public class BasePojo implements Serializable
{
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
