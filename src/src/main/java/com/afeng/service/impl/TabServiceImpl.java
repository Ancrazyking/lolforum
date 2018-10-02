package com.afeng.service.impl;

import com.afeng.mapper.TabDao;
import com.afeng.pojo.Tab;
import com.afeng.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author afeng
 * @date 2018/9/29 22:04
 **/
@Service
public class TabServiceImpl implements TabService
{
    @Autowired
    private TabDao tabDao;

    public List<Tab> selectAllTabs()
    {
        return tabDao.selectAllTabs();
    }

    public Tab selectByTabNameEn(String tabName)
    {
        return tabDao.selectTabByTabNameEn(tabName);
    }
}
