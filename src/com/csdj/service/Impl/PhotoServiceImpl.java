package com.csdj.service.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.Impl.PhotoDaoImpl;
import com.csdj.dao.PhotoDao;
import com.csdj.entity.photo;
import com.csdj.service.PhotoService;
import com.csdj.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @program: boke
 *
 * @description: 相册Service 实现类
 *
 * @author: YinKang
 *
 * @create: 2018-12-17
 **/
public class PhotoServiceImpl implements PhotoService {
    //定义相册dao
  private PhotoDao photoDao;
  //构造方法中用向上转向实例化相册实现类
  public PhotoServiceImpl(){
      photoDao=new PhotoDaoImpl();
  }

    /**
     * 查询相册主页
     * @return
     */
    @Override
    public List<photo> selPhoto() {
      Connection connection=null;
      List<photo> photoList=new ArrayList<photo>();
        try {
            connection= BaseDao.getConnection();
            photoList=photoDao.selPhoto(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return photoList;
    }

    /**
     * 查询个人介绍添加几张图片
     * @return
     */
    @Override
    public List<photo> UserPhoto() {
        Connection connection=null;
        List<photo> photoList=new ArrayList<photo>();
        try {
            connection= BaseDao.getConnection();
            photoList=photoDao.UserPhoto(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return photoList;
    }

    /**
     * 查询全部图片
     * @return
     */
    @Override
    public List<photo> Photo() {
        Connection connection=null;
        List<photo> photoList=new ArrayList<photo>();
        try {
            connection= BaseDao.getConnection();
            photoList=photoDao.Photo(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return photoList;
    }

    /**
     * 按类型查询图片
     * @param p
     * @return
     */
    @Override
    public List<photo> typeList(photo p) {
      Connection connection=null;
        List<photo> photoList=new ArrayList<photo>();
        try {
            connection=BaseDao.getConnection();
            photoList=photoDao.typeList(connection,p);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return photoList;
    }

    /**
     * 查询所有图片后台管理
     * @return
     */
    @Override
    public List<photo> PhotoSel(int currPageNo,int pageSize) {
        Connection connection=null;
        List<photo> photoList=new ArrayList<photo>();
        try {
            connection= BaseDao.getConnection();
            photoList=photoDao.PhotoSel(connection,currPageNo,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return photoList;
    }

    /**
     * 查询所有类型
     * @return
     */
    @Override
    public List<photo> PType() {
        Connection connection=null;
        List<photo> photoList=new ArrayList<photo>();
        try {
            connection= BaseDao.getConnection();
            photoList=photoDao.PType(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return photoList;
    }

    /**
     * 查询总条数
     * @return
     */
    @Override
    public int count() {
        Connection connection=null;
        int count=0;
        try {
            connection=BaseDao.getConnection();
            count=photoDao.count(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 修改图片
     * @param photo
     * @return
     */
    @Override
    public int update(photo photo) {
        Connection connection=null;
        int resule=0;
        try {
            connection=BaseDao.getConnection();
            resule=photoDao.update(connection,photo);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return resule;
    }

    /**
     * 删除图片
     * @param photo
     * @return
     */
    @Override
    public int delePhoto(photo photo) {
        Connection connection=null;
        int resule=0;
        try {
            connection=BaseDao.getConnection();
            resule=photoDao.delePhoto(connection,photo);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return resule;
    }
}
