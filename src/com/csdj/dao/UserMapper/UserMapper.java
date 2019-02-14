package com.csdj.dao.UserMapper;

import com.csdj.entity.User;
import com.csdj.util.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 用户接口
 */
public interface UserMapper {
    /**
     * 查找是否登录成功
     * @param username
     * @param password
     * @return
     */
    public User findUser(Connection connection, String username, String password) throws SQLException;

    /**
     * 注册用户
     * @param user
     * @return
     */
    public int insertUser(Connection connection,User user) throws SQLException;

    /**
     * 查询单个用户，或者多个用户
     * @param user
     * @return
     */
    public List<User> selUsers(Connection connection,User user) throws SQLException;

    /**
     * 修改密码
     * @param xinpwd
     * @param username
     * @param jiupwd
     * @return
     */
    public int updateUser(Connection connection,String xinpwd,String username,String jiupwd) throws SQLException;

    /**
     * 重置密码
     * @param xinpwd
     * @param username
     * @param email
     * @return
     */
    public int resetPwd(Connection connection,String xinpwd,String username,String email) throws SQLException;
    /**
     * 删除用户
     * @param user
     * @return
     */
    public int deleteUser(Connection connection,User user) throws SQLException;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectUser(Connection connection,User user1,int pageNo,int pageSize) throws SQLException;

    /**
     * 查询总记录数
     * @return
     * @throws SQLException
     */
    public int selectCount(Connection connection) throws SQLException;

    /**
     * 修改用户信息
     * @param connection
     * @return
     * @throws SQLException
     */
    public int updateUsers(Connection connection,User user)throws SQLException;

    /**
     * 查询所有小黑屋用户
     * @param connection
     * @param page
     * @return
     * @throws Exception
     */
    public List<User> blockUser(Connection connection, Page page)throws Exception;

    /**
     * 更新小黑屋用户
     * @param connection
     * @param user
     * @return
     * @throws Exception
     */
    public int updateBlock(Connection connection,User user)throws Exception;

    /**
     * 删除小黑屋用户
     * @param connection
     * @param user
     * @return
     * @throws Exception
     */
    public int delBlock(Connection connection,User user)throws Exception;
    /**
     * 查询小黑屋总记录数
     * @return
     * @throws SQLException
     */
    public int blockCount(Connection connection) throws SQLException;
}
