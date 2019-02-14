package com.csdj.service.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.Impl.InformsDaoImpl;
import com.csdj.dao.InformsMapper.InformsMapper;
import com.csdj.entity.Informs;
import com.csdj.service.InformsServiceDao;

import java.sql.Connection;
import java.sql.SQLException;

public class InformServiceDaoImpl implements InformsServiceDao {
    private InformsMapper informsDao;
    public InformServiceDaoImpl(){
        informsDao=new InformsDaoImpl();
    }

    /**
     * 发布通知
     * @param informs
     * @return
     */
    @Override
    public int fabu(Informs informs) {
        Connection connection=null;
        int num=0;
        try{
            connection=BaseDao.getConnection();
            num=informsDao.fabu(connection,informs);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return num;
    }

    @Override
    public Informs inform(){
        Connection connection=null;
        Informs informs=null;
        try {
            connection= BaseDao.getConnection();
            informs=informsDao.inform(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return informs;
    }
}
