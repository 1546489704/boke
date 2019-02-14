package com.csdj.dao.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.YuluMapper.YuluMapper;
import com.csdj.entity.yulu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 语录
 */
public class YuluDaoImpl implements YuluMapper {

    /*
    查询
     */
    public List<yulu> selectAll(Connection conn) throws SQLException {
        //创建对象
        List<yulu> li=new ArrayList<yulu>();
        ResultSet resultSet=null;
        PreparedStatement pre=null;
        yulu yulu=null;
        if(conn!=null){
            //SQL语句
            String sql="SELECT * FROM yulu ORDER  BY  `time`  DESC";
            List<Object> list=new ArrayList<Object>();
            //执行SQL
            resultSet= BaseDao.executeQuery(conn,pre,resultSet,sql,list);
            while(resultSet.next()){
                yulu=new yulu();
                yulu.setId(resultSet.getInt("id"));
                yulu.setName(resultSet.getString("name"));
                yulu.setTime(resultSet.getString("time"));
                yulu.setYulu(resultSet.getString("yulu"));
                yulu.setLeibie(resultSet.getString("leibie"));
                li.add(yulu);
            }
            //关闭执行
            BaseDao.closeResource(null,pre,null);
        }
        return li;
    }

    /**
     * 删除
     */
    public int delectByid(Connection conn, int id) throws SQLException {
        PreparedStatement per=null;
        int i=0;
        if(conn!=null){
            //SQL语句
            String sql="DELETE FROM yulu WHERE id=?";
            List<Object> list=new ArrayList<Object>();
            list.add(id);
            //打开执行
            i=BaseDao.executeUpdate(conn,per,sql,list);
            //关闭执行
            BaseDao.closeResource(null,per,null);

        }
        return i;
    }

    /**
     * 增加
     */
    public int insertYulu(Connection conn, yulu yulu) throws SQLException {
        PreparedStatement per=null;
        int i=0;
        if(conn!=null){
            String sql="INSERT INTO yulu(`name`,`time`,yulu,leibie)VALUES(?,?,?,?)";
            List<Object> list=new ArrayList<Object>();
            list.add(yulu.getName());
            list.add(yulu.getTime());
            list.add(yulu.getYulu());
            list.add(yulu.getLeibie());
            i=BaseDao.executeUpdate(conn,per,sql,list);
            BaseDao.closeResource(null,per,null);
        }
        return i;
    }

    /**
     * 修改
     * @param conn
     * @param yulu
     * @return
     * @throws SQLException
     */
    @Override
    public int updateYulu(Connection conn, yulu yulu) throws SQLException {
        PreparedStatement pstm=null;
        int result=0;
        List<Object> obj=new ArrayList<Object>();
        obj.add(yulu.getName());
        obj.add((yulu.getTime()));
        obj.add(yulu.getYulu());
        obj.add(yulu.getLeibie());
        obj.add(yulu.getId());
        String sql="UPDATE yulu SET `name`=?,`time`=?,yulu=?,leibie=? WHERE id=?";
        result=BaseDao.executeUpdate(conn,pstm,sql,obj);
        //关闭连接
        BaseDao.closeResource(null,pstm,null);
        return result;
    }
}
