package com.csdj.service;

import com.csdj.entity.Leaves;

import java.sql.Connection;
import java.util.List;

public interface LeavesService {
    /**
     * 查询所有的留言
     * @return
     */
    public List<Leaves> SesLeaves();
    /**
     * 按id删除评论
     * @param id
     * @return
     */
    public int DatLeaves(int id);
    /**
     * 查询所有的留言+头像
     * @return
     */
    public List<Leaves> SelecLeaves();
    /**
     * 添加数据
     * @return
     */
    public int InnLeaves(int id,String name);
}
