package com.csdj.service.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.Impl.YuluDaoImpl;
import com.csdj.dao.YuluMapper.YuluMapper;
import com.csdj.entity.yulu;
import com.csdj.service.YuluServiceDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class YuluServiceDaoimpl implements YuluServiceDao  {
    private YuluMapper yuludao;

    public  YuluServiceDaoimpl(){
        yuludao=new YuluDaoImpl();

    }

    /**
     * 查询
     * @return
     */
    @Override
    public List<yulu> selectAll() {
        List<yulu> list=null;
        Connection conn=null;
        yulu yulu=null;
        try {
            conn= BaseDao.getConnection();
            list=yuludao.selectAll(conn);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn ,null,null);
        }
        return list;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delectByid( int id) {
        Connection conn=null;
        int i=0;
        try {
            conn=BaseDao.getConnection();
            i=yuludao.delectByid(conn,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        return i;
    }

    /**
     * 插入
     * @param yulu
     * @return
     */
    @Override
    public int insertYulu( yulu yulu) {
        Connection conn=null;
        int y=0;
        try {
            conn=BaseDao.getConnection();
            y=yuludao.insertYulu(conn,yulu);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        return y;
    }

    /**
     * UpdateYulu
     * @param yulu
     * @return
     */
    @Override
    public int updateYulu(yulu yulu) {
        Connection connection=null;
        int result=0;
        try {
            connection=BaseDao.getConnection();
            result=yuludao.updateYulu(connection,yulu);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return result;
    }
}
