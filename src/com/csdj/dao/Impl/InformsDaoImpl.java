package com.csdj.dao.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.InformsMapper.InformsMapper;
import com.csdj.entity.Informs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformsDaoImpl implements InformsMapper {
    @Override
    public int fabu(Connection connection, Informs informs) throws SQLException {
        PreparedStatement pstm = null;
        int num=0;
        if(connection!=null){
            String sql="INSERT INTO informs(informText,datatime) VALUES(?,?)";
            List<Object> list = new ArrayList<Object>();
            list.add(informs.getInformText());
            list.add(informs.getDatatime());
            num=BaseDao.executeUpdate(connection,pstm,sql,list);
            //释放资源
            BaseDao.closeResource(null, pstm, null);
        }
        return num;
    }

    @Override
    public Informs inform(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        List<Object> list = new ArrayList<Object>();
        ResultSet rs = null;
        Informs informs=null;
        if(connection!=null){
            String sql="SELECT * FROM `informs` ORDER BY datatime DESC LIMIT 1";
            rs = BaseDao.executeQuery(connection, pstm, rs, sql,list);
            if(rs.next()){
                int informid=rs.getInt("informId");
                String informText=rs.getString("informText");
                String datatime=rs.getString("datatime");
                informs=new Informs(informid,datatime,informText);
            }
            //释放资源
            BaseDao.closeResource(null, pstm, rs);
        }
        return informs;
    }
}
