package com.csdj.dao.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.LeavesMapper.LeavesMapper;
import com.csdj.entity.Leaves;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeavesDaoImpl implements LeavesMapper {
    /**
     * 查询所有的留言
     * @param connection
     * @return
     */
    public List<Leaves> SesLeaves(Connection connection) throws SQLException {
        //定义List集合
        List<Leaves> list=new ArrayList<Leaves>();
        List<Object> list1=new ArrayList<Object>();
        //初始化预编译
        PreparedStatement psmt=null;
        //结果集
        ResultSet rs=null;
        //编写查询sql
        String sql="select a.`leaveId`,a.`leaveText`,b.`uname`,c.`uname`,a.`leaveTime` from leaves as a ,users as b,users as c WHERE a.`putId`=b.`uId` and c.`uId`=a.`lyId`";
        //执行sql
        rs=BaseDao.executeQuery(connection,psmt,rs,sql,list1);
        while(rs.next()){
            Leaves le=new Leaves();
            le.setLeaveID(rs.getInt(1));
            le.setLeaveText(rs.getString(2));
            le.setPut(rs.getString(3));
            le.setLy(rs.getString(4));
            le.setLeaveTime(rs.getString(5));
            list.add(le);
        }
        //关闭数据连接
        BaseDao.closeResource(null,psmt,rs);
        return list;
    }

    /**
     * 按id删除评论
     * @param connection
     * @param id
     * @return
     * @throws SQLException
     */
    public int DatLeaves(Connection connection, int id) throws SQLException {
        int i=0;
        //定义List集合
        List<Object> list=new ArrayList<Object>();
        list.add(id);
        //编写删除sql
        String sql="DELETE from`LEAVES` where `leaveId`=?";
        //初始化预编译
        PreparedStatement psmt=null;
        //执行sql
        i=BaseDao.executeUpdate(connection,psmt,sql,list);
        //关闭数据连接
        BaseDao.closeResource(null,psmt,null);
        return i;
    }

    /**
     * 查询所有的留言+头像
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<Leaves> SelecLeaves(Connection connection) throws SQLException {
        //定义List集合
        List<Object> list1=new ArrayList<Object>();
        List<Leaves> list=new ArrayList<Leaves>();
        //结果集
        ResultSet rs=null;
        //初始化预编译
        PreparedStatement psmt=null;
        //编写查询sql
        String sql="select a.`leaveId`,a.`leaveText`,b.`uname`,c.`uname`,a.`leaveTime`,c.`prcture` from leaves as a ,users as b,users as c WHERE a.`putId`=b.`uId` and c.`uId`=a.`lyId` order by a.`leaveTime`DESC";
        //执行sql
        rs=BaseDao.executeQuery(connection,psmt,rs,sql,list1);
        while (rs.next()) {
            Leaves la=new Leaves();
            la.setLeaveID(rs.getInt(1));
            la.setLeaveText(rs.getString(2));
            la.setPut(rs.getString(3));
            la.setLy(rs.getString(4));
            la.setLeaveTime(rs.getString(5));
            la.setPrcture(rs.getString(6));
            list.add(la);
        }
        //关闭数据连接
        BaseDao.closeResource(null,psmt,rs);
        return list;
    }
    /**
     * 添加数据
     * @param connection
     * @return
     * @throws SQLException
     */
    public int InnLeaves(Connection connection, int id, String name) throws SQLException {
        int i=0;
        //定义List集合
        List<Object> list=new ArrayList<Object>();
        list.add(name);
        list.add(id);
        //初始化预编译
        PreparedStatement psmt=null;
        //编写添加sql
        String sql="insert into `LEAVES`(`putId`,`leaveText`,`lyId`,`leaveTime`)value(4,?,?,now());";
        //执行sql
        i=BaseDao.executeUpdate(connection,psmt,sql,list);
        //关闭数据连接
        BaseDao.closeResource(null,psmt,null);
        return i;
    }
}
