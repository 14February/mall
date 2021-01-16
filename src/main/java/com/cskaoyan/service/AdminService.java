package com.cskaoyan.service;

import com.cskaoyan.bean.backstage.admin.Admin;
import com.cskaoyan.bean.backstage.ListData;
import com.cskaoyan.bean.backstage.user.UserInfo;
import org.apache.shiro.subject.PrincipalCollection;

/**
 *
 */
public interface AdminService{


    UserInfo queryAdminByUsername(PrincipalCollection principals);

    ListData<Admin> queryAdmins(Integer page, Integer limit, String username, String sort, String order);
}
