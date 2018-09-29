package com.afeng.service;

import com.afeng.pojo.User;

/**
 * @author afeng
 * @date 2018/9/29 11:02
 **/
public interface UserService
{

    /**
     * 添加用户   注册
     *
     * @param user
     * @return
     */
    boolean addUser(User user);


    /**
     * 增加积分
     *
     * @param points
     * @param id
     * @return
     */
    boolean addCredit(Integer points, Integer id);


    /**
     * 检查用户名是否存在
     *
     * @param username
     * @return
     */
    boolean existUsername(String username);

    /**
     * 登录验证
     *
     * @param username
     * @param password
     * @return
     */
    int login(String username, String password);

    /**
     * 通过用户名获取用户信息
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 通过id获取用户信息
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);


    /**
     * 获取用户数
     *
     * @return
     */
    int totalUserCount();

    /**
     * 更新用户,修改用户信息
     *
     * @return
     */
    boolean updateUser(User user);
}
