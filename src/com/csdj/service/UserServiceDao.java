package com.csdj.service;

import com.csdj.entity.Posts;
import com.csdj.entity.User;
import com.csdj.util.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 用户业务逻辑接口
 */
public interface UserServiceDao {
    /**
     * 查找是否登录成功
     * @param username
     * @param password
     * @return
     */
    public User findUser(String username, String password);
    /**
     * 注册用户
     * @param user
     * @return
     */
    public int insertUser(User user);
    /**
     * 查询单个用户，或者多个用户
     * @param user
     * @return
     */
    public List<User> selUsers(User user);

    /**
     * 修改密码
     * @param xinpwd
     * @param username
     * @param jiupwd
     * @return
     */
    public int updateUser(String xinpwd,String username,String jiupwd);

    /**
     * 重置密码
     * @param xinpwd
     * @param username
     * @param email
     * @return
     */
    public int resetPwd(String xinpwd,String username,String email);

    /**
     * 删除用户
     * @param user
     * @return
     */
    public int deleteUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectUser(User user,int pageNo,int pageSize);

    /**
     * 查询总记录数
     * @return
     */
    public int selectCount();

    /**
     * 修改用户信息
     * @return
     */
    public int updateUsers(User user);
    /**
     * 查询小黑屋用户
     */
    public List<User> blockUser(Page page);
    /**
     * 更新小黑屋用户
     * @param user
     * @return
     * @throws Exception
     */
    public int updateBlock( User user);

    /**
     * 删除小黑屋用户
     * @param user
     * @return
     * @throws Exception
     */
    public int delBlock(User user);
    /**
     * 查询小黑屋总记录数
     * @return
     * @throws SQLException
     */
    public int blockCount() ;

}
