package com.csdj.dao.AdminMapper;

import com.csdj.entity.Admin;

/**
 *
 * 后台管理员接口
 */
public interface AdminMapper {
    /**
     * 管理员登入
     */
    public Admin findAdmin(Admin admin);

    /**
     * 修改管理员资料
     */
    public int uppdateAdmin(Admin admin);

    /**
     * 添加管理员
     */
    public int insertAdmin(Admin admin);
}
