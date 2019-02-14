package com.csdj.dao.PhotoMapper;

import com.csdj.entity.photo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 相册接口
 */
public interface PhotoMapper {
    /**
     * 查询相册主页
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<photo> selPhoto(Connection connection) throws SQLException;

    /**
     * 查询个人介绍添加几张图片
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<photo> UserPhoto(Connection connection) throws SQLException;

    /**
     * 查询10张图片
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<photo> Photo(Connection connection) throws SQLException;

    /**
     * 按类型查询图片
     * @param connection
     * @param p
     * @return
     * @throws SQLException
     */
    public List<photo> typeList(Connection connection ,photo p) throws SQLException;

    /**
     * 后台管理查询所有图片
     * @param connection
     * @param currPageNo
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<photo> PhotoSel(Connection connection ,int currPageNo,int pageSize) throws SQLException;

    /**
     * 查询类型
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<photo> PType(Connection connection) throws SQLException;

    /**
     * 分页 查询总记录数
     * @param connection
     * @return
     * @throws SQLException
     */
    public int count(Connection connection)throws  SQLException;

    /**
     * 修改图片内容
     * @param connection
     * @param photo
     * @return
     * @throws SQLException
     */
    public int update(Connection connection ,photo photo)throws  SQLException;

    /**
     * 删除图片
     * @param connection
     * @param photo
     * @return
     * @throws SQLException
     */
    public int delePhoto(Connection connection,photo photo)throws  SQLException;

}
