package com.afeng.service.impl;

import com.afeng.mapper.LoginLogDao;
import com.afeng.pojo.LoginLog;
import com.afeng.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author afeng
 * @date 2018/9/29 22:10
 **/
@Service
public class LoginLogServiceImpl implements LoginLogService
{
    @Autowired
    private LoginLogDao loginLogDao;


    public boolean addLoginLog(LoginLog loginLog)
    {
        return loginLogDao.insertLoginLog(loginLog) > 0;
    }


}
