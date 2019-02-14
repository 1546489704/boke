package com.csdj.dao.YuluMapper;

import com.csdj.entity.yulu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface YuluMapper {
    /*
    查询
     */
    public List<yulu> selectAll(Connection conn)throws SQLException;

    /*
    删除
     */
    public int delectByid(Connection conn,int id )throws  SQLException;

    /*
    增加
     */
    public int insertYulu(Connection conn,yulu yulu)throws  SQLException;

    /*
  修改
   */
    public int updateYulu(Connection conn,yulu yulu)throws  SQLException;
}
