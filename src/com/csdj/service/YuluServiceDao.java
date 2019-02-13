package com.csdj.service;

import com.csdj.entity.yulu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface YuluServiceDao {


    /*
   查询
    */
    public List<yulu> selectAll();

    /*
    删除
     */
    public int delectByid(int id );

    /*
    增加
     */
    public int insertYulu(yulu yulu);


    /*
  修改
   */
    public int updateYulu(yulu yulu);
}
