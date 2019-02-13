package com.csdj.service.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.Impl.UserDaoImpl;
import com.csdj.dao.UserDao;
import com.csdj.entity.Posts;
import com.csdj.entity.User;
import com.csdj.service.UserServiceDao;
import com.csdj.util.DataBaseUtil;
import com.csdj.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: boke
 *
 * @description: 用户业务逻辑
 *
 * @author: H丶丢心先生
 *
 * @create: 2018-12-17 08:54
 **/
public class UserServiceDaoImpl implements UserServiceDao {
   private UserDao userDao;
   public UserServiceDaoImpl(){
       userDao=new UserDaoImpl();
   }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> selectUser(User user,int pageNo,int pageSize) {
        Connection connection = null;
        List<User> list=new ArrayList<User>();
        try{
            connection=BaseDao.getConnection();
            list=userDao.selectUser(connection,user,pageNo,pageSize);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return list;
    }

    /**
     * 根据用户名密码查找匹配的用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findUser(String username, String password) {

        Connection connection = null;
        User user=null;
        try {
            connection = BaseDao.getConnection();
            user=userDao.findUser(connection,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection,null,null);
        }

        return user;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
       Connection connection=null;
       int resule=0;
        try {
            connection=BaseDao.getConnection();
            resule=userDao.insertUser(connection,user);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return resule;
    }

    /**
     * 查询单个或者多个用户
     * @param user
     * @return
     */
    @Override
    public List<User> selUsers(User user) {
        Connection connection=null;
        List<User> list = new ArrayList<User>();
        try{
            connection=BaseDao.getConnection();
            list=userDao.selUsers(connection,user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return list;
    }

    /**
     * 修改用户
     * @param xinpwd
     * @param username
     * @param jiupwd
     * @return
     */
    @Override
    public int updateUser(String xinpwd,String username,String jiupwd) {
        Connection connection=null;
        int resule=0;
        try {
            connection=BaseDao.getConnection();
            resule=userDao.updateUser(connection,xinpwd,username,jiupwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return resule;
    }

    /**
     * 重置密码
     * @param xinpwd
     * @param username
     * @param email
     * @return
     */
    @Override
    public int resetPwd(String xinpwd, String username, String email) {
        Connection connection=null;
        int resule=0;
        try {
            connection=BaseDao.getConnection();
            resule=userDao.resetPwd(connection,xinpwd,username,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return resule;
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @Override
    public int deleteUser(User user) {
        Connection connection=null;
        int num=0;
        try{
            connection=BaseDao.getConnection();
            num=userDao.deleteUser(connection,user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return num;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public int updateUsers(User user) {
        Connection connection=null;
        int num=0;
        try{
            connection=BaseDao.getConnection();
            num=userDao.updateUsers(connection,user);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return num;
    }

    /**
     * 更新小黑屋中用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int updateBlock( User user) {
        int result=0;
        //初始化连接
        Connection conn=null;
        try{
            conn=BaseDao.getConnection();
            result=userDao.updateBlock(conn,user);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        return result;
    }

    /**
     * 删除小黑屋用户
     * @param user
     * @return
     * @throws Exception
     */
    public int delBlock( User user)  {
        int result=0;
        //初始化Connection
        Connection conn=null;
        try {
            conn=BaseDao.getConnection();
            result=userDao.delBlock(conn,user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            BaseDao.closeResource(conn,null,null);
        }
        return result;
    }
    //小黑屋统计总数
    @Override
    public int blockCount() {
        Connection conn=null;
        int reslut=0;
        try{
            conn=BaseDao.getConnection();
            reslut=userDao.blockCount(conn);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        return reslut;
    }

    /**
     * 查询小黑屋用户
     * @return
     */
    @Override
    public List<User> blockUser(Page page) {
        Connection conn = null;
        //定义User类型的List集合
        List<User> list=new ArrayList<User>();
        try{
            conn=BaseDao.getConnection();
            list=userDao.blockUser(conn,page);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            BaseDao.closeResource(conn,null,null);
        }
        return list;
    }

    /**
     * 查询总记录数
     * @return
     */
    @Override
    public int selectCount() {
        Connection connection=null;
        int num=0;
        try{
            connection=BaseDao.getConnection();
            num=userDao.selectCount(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return num;
    }
}
