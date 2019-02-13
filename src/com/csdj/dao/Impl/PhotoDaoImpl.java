package com.csdj.dao.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.PhotoDao;
import com.csdj.entity.photo;
import org.w3c.dom.ls.LSException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: boke
 *
 * @description: 相册dao实现类
 *
 * @author: YinKang
 *
 * @create: 2018-12-17
 **/
public class PhotoDaoImpl implements PhotoDao {
    @Override
    /**
     * 查询首页六张图片
     */
    public List<photo> selPhoto(Connection connection) throws SQLException {
        //初始化pstm
        PreparedStatement pstm=null;
        //初始化rs
        ResultSet rs=null;
        List<photo> selPhoto=new ArrayList<photo>(); //定义相册泛型list
        //初始化相册类
        photo pt=null;
        if(null!=connection) {
            String sql = "SELECT uid,photo,`describe`,`time` FROM Photo LIMIT 6"; //sql
            List<Object> list = new ArrayList<Object>(); //初始化Object集合
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, list); //调用dao通用方法处理sql，跟预编译
            while (rs.next()) {
                pt = new photo();
                pt.setUid(rs.getInt(1));
                pt.setPicture(rs.getString(2));
                pt.setIntroduce(rs.getString(3));
                pt.setDate(rs.getString(4));
                selPhoto.add(pt);

            }
            //使用完后调用dao关闭资源
            BaseDao.closeResource(null,pstm,rs);
        }
        //返回值
        return selPhoto;
    }

    /**
     * 个人介绍四张图片
     * @param connection
     * @return
     * @throws SQLException
     */
    @Override
    public List<photo> UserPhoto(Connection connection) throws SQLException {
        //初始化pstm
        PreparedStatement pstm=null;
        //初始化rs
        ResultSet rs=null;
        List<photo> UserPhoto=new ArrayList<photo>(); //定义相册泛型list
        photo pt=null;
        if(null!=connection) {
            String sql = "SELECT uid,photo,`describe`,`time` FROM Photo LIMIT 6,4"; //sql
            List<Object> list = new ArrayList<Object>();//定义Object集合
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, list);  //调用dao通用方法处理sql，跟预编译
            while (rs.next()) {
                pt = new photo();
                pt.setUid(rs.getInt(1));
                pt.setPicture(rs.getString(2));
                pt.setIntroduce(rs.getString(3));
                pt.setDate(rs.getString(4));
                UserPhoto.add(pt); //循环完一条装集合里面

            }
            //使用完资源后调用dao关闭方法关闭资源
            BaseDao.closeResource(null,pstm,rs);
        }
        //返回
        return UserPhoto;
    }

    /**
     * 查询10张图片
     * @param connection
     * @return
     * @throws SQLException
     */
    @Override
    public List<photo> Photo(Connection connection) throws SQLException {
        //初始化pstm
        PreparedStatement pstm=null;
        //初始化rs
        ResultSet rs=null;
        List<photo> UserPhoto=new ArrayList<photo>();//定义相册泛型list
        //初始化相册类
        photo pt=null;
        if(null!=connection) {
            String sql = "SELECT uid,photo,`describe`,`time` FROM Photo LIMIT 10 "; //sql
            List<Object> list = new ArrayList<Object>(); //定义Object集合
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, list);  //调用dao通用方法处理sql，跟预编译
            while (rs.next()) {
                pt = new photo();
                pt.setUid(rs.getInt(1));
                pt.setPicture(rs.getString(2));
                pt.setIntroduce(rs.getString(3));
                pt.setDate(rs.getString(4));
                UserPhoto.add(pt);//循环完一条装集合里面

            }
            //使用完资源后调用dao关闭方法关闭资源
            BaseDao.closeResource(null, pstm, rs);
        }
        //返回结果集
        return UserPhoto;
    }

    /**
     * 按类型查询图片
     * @param connection
     * @param p
     * @return
     * @throws SQLException
     */
    @Override
    public List<photo> typeList(Connection connection, photo p) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pstm=null;
        photo pt=null;
        List<photo> typeList=new ArrayList<photo>();
        List<Object> list = new ArrayList<Object>();
        list.add(p.getType());
        if(null!=connection){
            String sql="SELECT id, uid,photo,`describe`,`time`,type FROM Photo where type=?";
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, list);
            while (rs.next()) {
                pt = new photo();
                pt.setPhId(rs.getInt(1));
                pt.setUid(rs.getInt(2));
                pt.setPicture(rs.getString(3));
                pt.setIntroduce(rs.getString(4));
                pt.setDate(rs.getString(5));
                pt.setType(rs.getString(6));
                typeList.add(pt);

            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return typeList;
    }

    /**
     * /查询所有图片
     * @param connection
     * @param currPageNo
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<photo> PhotoSel(Connection connection,int currPageNo,int pageSize) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<photo> UserPhoto=new ArrayList<photo>();
        List<Object> list = new ArrayList<Object>();
        int pageNo=(currPageNo-1)*pageSize;
        list.add(pageNo);
        list.add(pageSize);
        photo pt=null;
        if(null!=connection) {
            String sql = "SELECT id, uid,photo,`describe`,`time`,type FROM Photo limit ?,? ";
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, list);
            while (rs.next()) {
                pt = new photo();
                pt.setPhId(rs.getInt(1));
                pt.setUid(rs.getInt(2));
                pt.setPicture(rs.getString(3));
                pt.setIntroduce(rs.getString(4));
                pt.setDate(rs.getString(5));
                pt.setType(rs.getString(6));
                UserPhoto.add(pt);

            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return UserPhoto;
    }

    /**
     * /查询类型
     * @param connection
     * @return
     * @throws SQLException
     */
    @Override
    public List<photo> PType(Connection connection) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<photo> UserPhoto=new ArrayList<photo>();
        photo pt=null;
        if(null!=connection) {
            String sql = "SELECT type FROM Photo GROUP BY TYPE ";
            List<Object> list = new ArrayList<Object>();
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, list);
            while (rs.next()) {
                pt = new photo();
                pt.setType(rs.getString(1));
                UserPhoto.add(pt);

            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return UserPhoto;
    }

    /**
     * 查询总数量
     * @param connection
     * @return
     * @throws SQLException
     */
    @Override
    public int count(Connection connection) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Object> obj=new ArrayList<Object>();
        int count=0;
        if(null!=connection) {
            String sql = "select count(1) from Photo";
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, obj);
            if (rs.next()) {
                count = rs.getInt(1);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return count;
    }

    /**
     * //修改图片编辑
     * @param connection
     * @param photo
     * @return
     * @throws SQLException
     */
    @Override
    public int update(Connection connection,photo photo) throws SQLException {
        PreparedStatement pstm=null;
        List<Object> obj=new ArrayList<Object>();
        obj.add(photo.getIntroduce());
        obj.add(photo.getDate());
        obj.add(photo.getType());
        obj.add(photo.getPhId());
        int result=0;
        String sql="UPDATE photo SET `describe`=?,`time`=?,`type`=? WHERE id=?";
        result=BaseDao.executeUpdate(connection,pstm,sql,obj);
        BaseDao.closeResource(null,pstm,null);
        return result;
    }


    /**
     * 删除图片
     * @param connection
     * @param photo
     * @return
     * @throws SQLException
     */
    @Override
    public int delePhoto(Connection connection, photo photo) throws SQLException {
        PreparedStatement pstm=null;
        List<Object> obj=new ArrayList<Object>();
        obj.add(photo.getPhId());
        int result=0;
        String sql="DELETE FROM photo WHERE id=?";
        result=BaseDao.executeUpdate(connection,pstm,sql,obj);
        BaseDao.closeResource(null,pstm,null);
        return result;
    }

}
