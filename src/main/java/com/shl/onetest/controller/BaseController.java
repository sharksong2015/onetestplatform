package com.shl.onetest.controller;

import com.github.pagehelper.PageInfo;
import com.shl.onetest.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songhongli
 **/

public class BaseController {
    protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    public User getCurrentUser() {
        return (User) getSubject().getPrincipal();
    }

    public Subject getSubject(){
        return SecurityUtils.getSubject();
    }


}
