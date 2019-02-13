package com.csdj.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * 帮助类
 */
public class BaseDao {
//
//    static{//静态代码块,在类加载的时候执行
//        init();
//    }

    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/blog?useUnicode=true&useSSL=false&characterEncoding=utf-8";
    private static String user="root";
    private static String password="root123";

//    //初始化连接参数,从配置文件里获得
//    public static void init(){
//        Properties params=new Properties();
//        String configFile = "database.properties";
//        InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configFile);
//        try {
//            params.load(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        driver=params.getProperty("driver");
//        url=params.getProperty("url");
//        user=params.getProperty("user");
//        password=params.getProperty("password");
//        System.out.println(password);
//
//    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connection;
    }
    /**
     * 增、删、改操作
     *
     * @param sql
     *            sql语句
     * @param
     *
     * @return 执行结果
     */
    public static int executeUpdate(Connection connection,PreparedStatement pstm,String sql, List<Object> params) throws SQLException {
        int result = 0;
            pstm = connection.prepareStatement(sql);
            if(params.size()==0||params==null){
                result = pstm.executeUpdate();
            }else{
                for (int i = 0; i < params.size(); i++) {
                    pstm.setObject((i + 1), params.get(i));
                }
            }
            result = pstm.executeUpdate();

        return result;
    }
    /**
     * 查询操作
     *
     * @param sql
     *            sql语句
     * @param params
     *            参数数组
     * @return 查询结果集
     */
    public static ResultSet executeQuery(Connection connection,PreparedStatement pstm,ResultSet rs,String sql, List<Object> params) throws SQLException {
            pstm = connection.prepareStatement(sql);
           if(params.size()==0||params.equals(null)){
               rs = pstm.executeQuery();
           }else {
               for (int i = 0; i < params.size(); i++) {
                   pstm.setObject((i + 1), params.get(i));

               }
               rs = pstm.executeQuery();
           }

        return rs;
    }

    /**
     * 释放资源
     * @param connection
     * @param pstm
     * @param rs
     * @return
     */
    public static boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
        boolean flag = true;
        if(rs != null){
            try {
                rs.close();
                rs = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(pstm != null){
            try {
                pstm.close();
                pstm = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(connection != null){
            try {
                connection.close();
                connection = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }

        return flag;
    }
}
