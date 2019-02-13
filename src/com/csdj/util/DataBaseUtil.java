package com.csdj.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseUtil {

    static   Connection conn=null;
    public static Connection getConnection() {
        try {
//            Context ctx=new InitialContext();
//            DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/boke");
//
//            conn=ds.getConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
           Class.forName("com.mysql.jdbc.Driver"); //加载驱动
            // 创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false", "root", "root123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关闭
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若Statement对象不为空，则关闭
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若数据库连接对象不为空，则关闭
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
