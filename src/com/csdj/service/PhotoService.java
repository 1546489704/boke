package com.csdj.service;

import com.csdj.entity.photo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 相册service接口
 */
public interface PhotoService {
    /**
     * 查询相册主页
     * @return
     */
    public List<photo> selPhoto();

    /**
     * 查询个人介绍添加几张图片
     * @return
     */
    public List<photo> UserPhoto();

    /**
     * 查询全部图片
     * @return
     */
    public List<photo> Photo();


    /**
     * 按类型查询图片
     * @param p
     * @return
     */
    public List<photo> typeList(photo p);

    /**
     * 后台管理查询所有图片
     * @param currPageNo
     * @param pageSize
     * @return
     */
    public List<photo> PhotoSel(int currPageNo,int pageSize) ;

    /**
     * 后台管理查询类型
     * @return
     */
    public List<photo> PType();


    /**
     * 分页 查询总记录数
     * @return
     */
    public int count();

    /**
     * 修改图片内容
     * @param photo
     * @return
     */
    public int update(photo photo);


    /**
     * 删除图片
     * @param photo
     * @return
     */
    public int delePhoto(photo photo);
}
