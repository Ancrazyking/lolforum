package com.afeng.service.impl;

import com.afeng.mapper.UserDao;
import com.afeng.pojo.User;
import com.afeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author afeng
 * @date 2018/9/29 11:03
 **/
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public boolean addUser(User user)
    {
        return userDao.addUser(user) > 0;
    }

    /**
     * 增加积分
     *
     * @param points
     * @param id
     * @return
     */
    public boolean addCredit(Integer points, Integer id)
    {
        return userDao.addCredit(points, id) > 0;
    }

    /**
     * 检验用户名是否存在
     *
     * @param username
     * @return
     */
    public boolean existUsername(String username)
    {
        return userDao.existUsername(username) == 1;
    }

    /**
     * 用户登录验证  0:用户名不存在  1:密码错误  2:验证成功
     *
     * @param username
     * @param password
     * @return
     */
    public int login(String username, String password)
    {   //判断用户名是否存在,若存在,验证密码
        boolean result = existUsername(username);
        if (result)
        {
            User loginUser = userDao.selectUserByUsername(username);
            if (loginUser.getPassword().equals(password))
            {
                //用户名和密码验证成功
                return 2;
            }
            //密码不匹配
            return 1;
        }
        //用户名不存在
        return 0;
    }

    /**
     * 登录后获取用户信息
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username)
    {
        return userDao.selectUserByUsername(username);
    }

    /**
     * 通过id获取用户信息
     *
     * @param id
     * @return
     */
    public User getUserById(Integer id)
    {
        return userDao.selectUserById(id);
    }

    /**
     * 获取用户总数
     *
     * @return
     */
    public int totalUserCount()
    {
        return userDao.totalUserCount();
    }

    /**
     * 更新,修改用户信息
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user)
    {
        return userDao.updateUserById(user) > 0;
    }
}
