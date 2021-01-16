package com.cskaoyan.service;

import com.cskaoyan.bean.backstage.ListData;
import com.cskaoyan.bean.backstage.admin.Admin;
import com.cskaoyan.bean.backstage.admin.AdminExample;
import com.cskaoyan.bean.backstage.user.UserInfo;
import com.cskaoyan.mapper.backstage.AdminMapper;
import com.cskaoyan.mapper.backstage.PermissionMapper;
import com.cskaoyan.mapper.backstage.RoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public UserInfo queryAdminByUsername(PrincipalCollection principals)
    {
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(principals.toString());
        List<Admin> admins = adminMapper.selectListByExample(example);
        Admin admin = admins.get(0);
        Integer[] roleIds = admin.getRoleIds();
        List<String> roles = roleMapper.selectRoleNameById(roleIds);
        List<String> permissions = permissionMapper.selectPermissionByRoleId(roleIds);
        UserInfo userInfo = new UserInfo();
        userInfo.setName(admin.getUsername());
        userInfo.setAvatar(admin.getAvatar());
        userInfo.setRoles(roles);
        userInfo.setPerms(permissions);
        return userInfo;
    }

    @Override
    public ListData<Admin> queryAdmins(Integer page, Integer limit, String username, String sort, String order) {
        AdminExample adminExample = new AdminExample();
        adminExample.setOrderByClause(sort + " " + order);
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if(username != null) criteria.andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectListByExample(adminExample);
        int size = 0;
        if(admins != null) size = admins.size();
        return ListData.data(size, admins);
    }
}
