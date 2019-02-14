package com.csdj.dao.InformsMapper;

import com.csdj.entity.Informs;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 系统通知表
 */
public interface InformsMapper {
    /**
     * 查询最新的系统通知
     */
    public Informs inform(Connection connection)  throws SQLException;

    /**
     * 发布一条最新通知
     * @param connection
     * @param informs
     * @return
     * @throws SQLException
     */
    public int fabu(Connection connection,Informs informs) throws SQLException;

}
