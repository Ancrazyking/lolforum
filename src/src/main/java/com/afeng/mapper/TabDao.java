package com.afeng.mapper;

import com.afeng.pojo.Tab;

import java.util.List;

/**
 * @author afeng
 * @date 2018/9/29 21:46
 **/
public interface TabDao
{
    /**
     * 插入标签
     *
     * @param tab
     * @return
     */
    int insertTab(Tab tab);


    /**
     * 查询所有标签种类
     *
     * @return
     */
    List<Tab> selectAllTabs();


    /**
     * 通过tabName查询对应的信息
     * 英文
     *
     * @param tabNameEn
     * @return
     */
    Tab selectTabByTabNameEn(String tabNameEn);
}
