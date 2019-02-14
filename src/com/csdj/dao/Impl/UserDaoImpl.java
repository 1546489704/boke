package com.csdj.dao.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.UserMapper.UserMapper;
import com.csdj.entity.User;
import com.csdj.util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: boke
 *
 * @description: 用户实现类
 *
 * @author: H丶丢心先生
 *
 * @create: 2018-12-17 08:54
 **/
public class UserDaoImpl  implements UserMapper {
    /**
     * 查找是否登录成功
     * @param connection
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public User findUser(Connection connection,String username, String password) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if(null!=connection) {
            String sql = "SELECT * FROM users WHERE uname=? AND password=?";
            List<Object> list = new ArrayList<Object>();
            list.add(username);
            list.add(password);
            // 根据用户名密码查找匹配的用户
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, list);
            if (rs.next()) {
                int uId = rs.getInt("uId");//id
                String uName = rs.getString("uName");//姓名
                int gradeid = rs.getInt("gradeid");//等级
                String pwd = rs.getString("password");//密码
                String sex = rs.getString("sex");//性别
                int age = rs.getInt("age");//年龄
                String phone = rs.getString("phone");//手机号码
                String email = rs.getString("email");//邮箱
                String career = rs.getString("career");//职业
                String hobby = rs.getString("hobby");//爱好
                String site = rs.getString("site");//地址
                String prcture = rs.getString("prcture");//头像
                //放入到构造方法
                user = new User(uId, uName, gradeid, pwd, sex, age, phone, email, career, hobby, site, prcture);
            }
            //释放资源
            BaseDao.closeResource(null, pstm, rs);
        }

        return user;
    }

    /**
     * 添加用户注册使用
     * @param connection
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int insertUser(Connection connection,User user) throws SQLException {
        int num=0;
        PreparedStatement pstm = null;
        if(null!=connection) {
            String sql = "INSERT INTO users(uname,PASSWORD,sex,age,phone,email,site,prcture) VALUES(?,?,?,?,?,?,?,?)";
            List<Object> list = new ArrayList<Object>();
            list.add(user.getuName());
            list.add(user.getPassword());
            list.add(user.getSex());
            list.add(user.getAge());
            list.add(user.getPhone());
            list.add(user.getEmail());
            list.add(user.getSite());
            list.add(user.getPrcture());
                num = BaseDao.executeUpdate(connection,pstm,sql,list);
            //释放资源
                 BaseDao.closeResource(null, pstm, null);

        }
        return num;
    }

    /**
     * 查询所有用户
     * @param connection
     * @return
     */
    @Override
    public List<User> selectUser(Connection connection,User user1,int pageNo,int pageSize) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pstmt=null;
        User user=null;
        List<User> li=new ArrayList<User>();
        if(connection!=null){
            List<Object> list = new ArrayList<Object>();
            String sql="SELECT uid,uname,sex,email,career FROM `users` where 1=1  and gradeid=1 or gradeid=100";

            if(user1.getSex()!=null&&user1.getSex().equals("男")){
                sql+=" and sex='男'";
            }else if(user1.getSex()!=null&&user1.getSex().equals("女")){
                sql+=" and sex='女'";
            }
            if(user1.getuName()!=null){
                sql+=" and uname like '%"+user1.getuName()+"%' ";
            }
            sql+=" limit ?,?";
            int num=(pageNo-1)*pageSize;
            list.add(num);
            list.add(pageSize);
            rs=BaseDao.executeQuery(connection,pstmt,rs,sql,list);
            while(rs.next()){
                user=new User();
                user.setuId(rs.getInt("uid"));
                user.setuName(rs.getString("uname"));
                user.setSex(rs.getString("sex"));
                user.setEmail(rs.getString("email"));
                user.setCareer(rs.getString("career"));
                li.add(user);
            }
            //释放资源
            BaseDao.closeResource(null,pstmt,rs);
        }
        return li;
    }

    /**
     * 查询个多用户或者多个用户
     * @param connection
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> selUsers(Connection connection,User user) throws SQLException{
        List<User> list = new ArrayList<User>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if(null!=connection){
            String sql="SELECT * FROM users WHERE uname=?";
            List<Object> li = new ArrayList<Object>();
            li.add(user.getuName());
            rs=BaseDao.executeQuery(connection,pstm,rs,sql,li);
            if(rs.next()){
                User user1=new User();
                user1.setuName(rs.getString("uname"));
                user1.setSex(rs.getString("sex"));
                user1.setHobby(rs.getString("hobby"));
                user1.setPrcture(rs.getString("prcture"));
                list.add(user1);
            }
            //释放资源
            BaseDao.closeResource(null,pstm,rs);
        }
        return list;
    }

    /**
     * 修改密码
     * @param connection
     * @param xinpwd
     * @param username
     * @param jiupwd
     * @return
     * @throws SQLException
     */
    @Override
    public int updateUser(Connection connection,String xinpwd,String username,String jiupwd) throws SQLException {
        PreparedStatement pstm=null;
        int num = 0;
        if(null!=connection) {
            String sql = "UPDATE users SET  `password`=? WHERE uname=? AND `password`=?";
            List<Object> list = new ArrayList<Object>();
            list.add(xinpwd);
            list.add(username);
            list.add(jiupwd);
            num = BaseDao.executeUpdate(connection,pstm,sql, list);
            //释放资源
           BaseDao.closeResource(null,pstm,null);
        }
        return num;
    }

    /**
     * 重置密码
     * @param connection
     * @param xinpwd
     * @param username
     * @param email
     * @return
     * @throws SQLException
     */
    @Override
    public int resetPwd(Connection connection,String xinpwd, String username, String email) throws SQLException {
        int num=0;
        PreparedStatement pstm=null;
        if(null!=connection) {
            String sql = "UPDATE users SET  `password`=? WHERE uname=? AND `email`=?";
            List<Object> list = new ArrayList<Object>();
            list.add(xinpwd);
            list.add(username);
            list.add(email);
            num=BaseDao.executeUpdate(connection, pstm, sql, list);
            //释放资源
            BaseDao.closeResource(null, pstm, null);
        }
        return num;
    }

    /**
     * 删除用户
     * @param connection
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteUser(Connection connection,User user) throws SQLException{
        int num=0;
        PreparedStatement pstmt=null;
        if(connection!=null){
            String sql="DELETE FROM users WHERE uid=?";
            List<Object> list = new ArrayList<Object>();
            list.add(user.getuId());
            num=BaseDao.executeUpdate(connection,pstmt,sql,list);
            BaseDao.closeResource(null,pstmt,null);
        }
        return num;
    }

    /**
     * 修改用户信息
     * @param connection
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int updateUsers(Connection connection,User user) throws SQLException {
        int num=0;
        //初始化预编译
        PreparedStatement pstmt=null;
        if(connection!=null){
            String sql="UPDATE users SET uname=?,sex=?,email=?,career=? WHERE uid=?";
            List<Object> list = new ArrayList<Object>();
            list.add(user.getuName());
            list.add(user.getSex());
            list.add(user.getEmail());
            list.add(user.getCareer());
            list.add(user.getuId());
            num=BaseDao.executeUpdate(connection,pstmt,sql,list);
            BaseDao.closeResource(null,pstmt,null);
        }
        return num;
    }

    /**
     * 查询小黑屋用户
     * @return
     * @throws Exception
     */
    @Override
    public List<User> blockUser(Connection connection,Page page) throws Exception {
        ResultSet rs=null;
        //初始化预编译
        PreparedStatement pstm=null;
        //定义User的List集合
        List<User> userList=new ArrayList<User>();
        //定义Object的List集合
        List<Object> obj=new ArrayList<Object>();
        if (null!=connection){
            //编写查询sql
            String sql="SELECT uid,uname,`gradeid`,career,hobby,site,`time` FROM users WHERE gradeid=50 ORDER BY `time` DESC";
            sql += " limit ?,?";
            int str = (page.getCurrPageNo() - 1) * page.getPageSize();
            obj.add(str);
            //页大小
            obj.add(page.getPageSize());
            //调用aseDao中查询通用方法
            rs=BaseDao.executeQuery(connection,pstm,rs,sql,obj);
            while (rs.next()){
                User user=new User();
                user.setuId(rs.getInt(1));
                user.setuName(rs.getString(2));
                user.setGradeid(rs.getInt(3));
                user.setCareer(rs.getString(4));
                user.setHobby(rs.getString(5));
                user.setSite(rs.getString(6));
                user.setTime(rs.getString(7));
                userList.add(user);
            }
            //释放资源
            BaseDao.closeResource(connection,pstm,rs);
        }
        return userList;
    }

    /**
     * 更新小黑屋用户
     * @param connection
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int updateBlock(Connection connection, User user) throws Exception {
        int result=0;
        //初始化预编译
        PreparedStatement pstm=null;
        //定义Object的List集合
        List<Object>obj=new ArrayList<Object>();
        obj.add(user.getuId());
        if (null!=connection){
            //编写更新sql
            String sql="UPDATE `users` SET gradeid=1  WHERE `uid`=?";
            //调用通用增删改方法
            result=BaseDao.executeUpdate(connection,pstm,sql,obj);
            //关闭连接
            BaseDao.closeResource(connection,pstm,null);
        }
        return result;
    }

    /**
     * 删除小黑屋用户
     * @param connection
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int delBlock(Connection connection, User user) throws Exception {
        int result=0;
        //初始化预编译
        PreparedStatement pstm=null;
        if (null!=null){
            //定义Object的List集合
            List<Object> obj=new ArrayList<Object>();
            obj.add(user.getuId());
            //编写删除sql
            String sql="DELETE FROM users WHERE uid =?";
            //调用通用增删改方法
            result=BaseDao.executeUpdate(connection,pstm,sql,obj);
            //关闭连接
            BaseDao.closeResource(connection,pstm,null);
        }
        return result;
    }

    /**
     * 查询小黑屋总记录数
     * @param connection
     * @return
     * @throws SQLException
     */
    @Override
    public int blockCount(Connection connection) throws SQLException {
        int reslut=0;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        if (null!=connection){
            //定义Object的List集合
            List<Object> list = new ArrayList<Object>();
            //编写统计小黑屋条数
            String sql="SELECT count(1) FROM users WHERE gradeid=50";
            //调用通用查询方法
            rs=BaseDao.executeQuery(connection,pstm,rs,sql,list);
            if (rs.next()) {
                reslut=rs.getInt(1);
            }
            //关闭连接
            BaseDao.closeResource(connection,pstm,rs);
        }

        return reslut;
    }

    /**
     * 查询总记录数
     * @return
     * @throws SQLException
     */
    @Override
    public int selectCount(Connection connection) throws SQLException {
        int num=0;
        //初始化预编译
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //定义Object的List集合
        List<Object> list = new ArrayList<Object>();
        if(connection!=null){
            //编写查询统计数
            String sql="select count(*) from users";
            //调用通用查询方法
            rs=BaseDao.executeQuery(connection,pstmt,rs,sql,list);
            while (rs.next()) {
                num=rs.getInt(1);
            }
        }
        return num;
    }
}
