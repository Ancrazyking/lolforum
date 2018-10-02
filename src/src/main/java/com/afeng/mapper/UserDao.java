package com.afeng.mapper;

import com.afeng.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author afeng
 * @date 2018/9/29 10:58
 **/
public interface UserDao
{
    /**
     * 用户名查询用户信息
     *
     * @param username
     * @return
     */
    User selectUserByUsername(String username);

    /**
     * 验证用户名是否存在
     *
     * @param username
     * @return
     */
    int existUsername(String username);

    /**
     * 添加用户,用于用户注册
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /**
     * 传入User对象
     * 通过Id更新用户
     *
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 增加用户积分
     *
     * @param points
     * @param id
     * @return
     */
    int addCredit(@Param("points") Integer points, @Param("id") Integer id);

    /**
     * 用户总数
     *
     * @return
     */
    int totalUserCount();


    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteUserById(Integer id);

}
