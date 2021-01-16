package com.cskaoyan.controller.backstage;

import com.cskaoyan.bean.both.BaseRespVo;
import com.cskaoyan.bean.backstage.Footprint;
import com.cskaoyan.bean.backstage.ListData;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyhstart
 * @description
 * @create 2021-01-10 15:12
 */
@RestController
@RequestMapping("admin/footprint")
public class AdminFootprintController{
    @Autowired
    UserService userService;

    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer limit, String sort, String order, Integer userId, Integer goodsId){
        ListData<Footprint> footprintListData = userService.queryFootprintList(page,limit,sort,order,userId,goodsId);
        return BaseRespVo.ok(footprintListData);
    }

}
