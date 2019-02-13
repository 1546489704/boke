package com.csdj.service;

import com.csdj.entity.Informs;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 系统通知表
 */
public interface InformsServiceDao {
    /**
     * 查询最新的系统通知
     */
    public Informs inform();

    /**
     * 发布通知
     * @param informs
     * @return
     */
    public int fabu(Informs informs);
}
