package com.csdj.dao.LeavesMapper;

import com.csdj.entity.Leaves;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface LeavesMapper {
    /**
     * 查询所有的留言
     * @param connection
     * @return
     */
    public List<Leaves> SesLeaves(Connection connection) throws SQLException;

    /**
     * 按id删除留言
     * @param connection
     * @param id
     * @return
     * @throws SQLException
     */
    public int DatLeaves(Connection connection,int id) throws  SQLException;

    /**
     * 查询所有的留言+头像
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<Leaves> SelecLeaves(Connection connection) throws  SQLException;

    /**
     * 添加数据
     * @param connection
     * @return
     * @throws SQLException
     */
    public int  InnLeaves(Connection connection,int id ,String name) throws  SQLException;
}
