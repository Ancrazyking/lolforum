package com.afeng.service;

import com.afeng.pojo.LoginLog;

/**
 * @author afeng
 * @date 2018/9/29 21:54
 **/
public interface LoginLogService
{
    /**
     * 插入一条登录日志
     *
     * @param loginLog
     * @return
     */
    boolean addLoginLog(LoginLog loginLog);
}
