package com.csdj.service.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.Impl.LeavesDaoImpl;
import com.csdj.dao.LeavesMapper.LeavesMapper;
import com.csdj.entity.Leaves;
import com.csdj.service.LeavesService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LeavesServiceImpl implements LeavesService {
    public LeavesMapper lb=new LeavesDaoImpl();
    /**
     * 查询所有的留言
     * @return
     */
    public List<Leaves> SesLeaves() {
        Connection connection=null;
        List<Leaves> list=new ArrayList<Leaves>();
        try{
        connection= BaseDao.getConnection();
        list=lb.SesLeaves(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return list;
    }

    /**
     * 按id删除评论
     * @param id
     * @return
     */
    public int DatLeaves(int id) {
        int i=0;
        Connection connection=null;
        try{
            connection=BaseDao.getConnection();
            i=lb.DatLeaves(connection,id);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return i;
    }

    /**
     * 查询所有的留言+头像
     * @return
     */

    public List<Leaves> SelecLeaves() {
        List<Leaves> list=new ArrayList<Leaves>();
        Connection connection=null;
        try{
            connection=BaseDao.getConnection();
            list=lb.SelecLeaves(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return list;
    }

    /**
     * 添加数据
     * @return
     */
    public int InnLeaves(int id, String name) {
        int i=0;
        Connection connection=null;
        try{
            connection=BaseDao.getConnection();
            i=lb.InnLeaves(connection,id,name);
        }catch (Exception e){

        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return i;
    }
}
