package com.shl.onetest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:songhongli
 * @Created: 2018/7/13
 */
@Data
public class Dept implements Serializable {
    private static final long serialVersionUID = -7790334862410409053L;
    private Long deptId;
    private Long parentId;
    private String deptName;
    private Long orderNum;
    private Date createTime;


}
