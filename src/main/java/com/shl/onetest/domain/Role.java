package com.shl.onetest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:songhongli
 * @Created: 2018/7/12
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -1714476694755654924L;
    private Long roleId;
    private String roleName;
    private String remark;
    private Date createTime;
    private Date modifyTime;

}
