package com.afeng.service;

import com.afeng.pojo.Tab;

import java.util.List;

/**
 * @author afeng
 * @date 2018/9/29 21:53
 **/
public interface TabService
{
    /**
     * 查询所有标签
     *
     * @return
     */
    List<Tab> selectAllTabs();

    /**
     * 查询Tab信息,通过标签的中文
     *
     * @param tabName
     * @return
     */
    Tab selectByTabNameEn(String tabName);

}
