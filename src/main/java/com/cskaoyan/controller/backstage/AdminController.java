package com.cskaoyan.controller.backstage;

import com.cskaoyan.bean.both.BaseRespVo;
import com.cskaoyan.bean.backstage.IndexVo;
import com.cskaoyan.bean.backstage.ListData;
import com.cskaoyan.bean.backstage.Log;
import com.cskaoyan.bean.backstage.admin.Admin;
import com.cskaoyan.map.OperationMap;
import com.cskaoyan.service.AdminService;
import com.cskaoyan.service.LogService;
import com.cskaoyan.service.MallSystemService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *
 */
@RequestMapping("admin")
@RestController
public class AdminController{

    @Autowired
    MallSystemService mallSystemService;

    @Autowired
    AdminService adminService;

    @Autowired
    LogService logService;

    @Autowired
    OperationMap operationMap;

    @RequestMapping("dashboard")
    public BaseRespVo<IndexVo> dashboard()
    {
        IndexVo indexVo = mallSystemService.selectTotals();
        return BaseRespVo.ok(indexVo);
    }

    @RequestMapping("log/list")
    public BaseRespVo<ListData<Log>> logList(Integer page,Integer limit,String sort,String order,String name)
    {
        ListData<Log> listData = logService.queryLogList(page,limit,sort,order,name);

        return BaseRespVo.ok(listData);
    }

    @GetMapping("admin/list")
    public BaseRespVo list(Integer page, Integer limit, String username, String sort, String order) {
        ListData<Admin> adminListData = adminService.queryAdmins(page, limit, username, sort, order);
        return BaseRespVo.ok(adminListData);
    }
}
