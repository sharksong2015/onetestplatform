package com.shl.onetest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:songhongli
 * @Created: 2018/7/13
 */
@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 7187628714679791771L;

    public static final String TYPE_MENU = "0";
    public static final String TYPE_BUTTON = "1";
    private Long menuId;
    private Long parentId;
    private String menuName;
    private String url;
    private String perms;
    private String icon;
    private String type;
    private Long orderNum;
    private Date createTime;
    private Date modifyTime;

}
