package com.shl.onetest.domain;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author songhongli
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -4852732617765810959L;
    private Long userId;
    private String username;
    private String password;
    private Long deptId;
    private String deptName;
    private String email;
    private String mobile;
    private String status;
    private Date crateTime;
    private Date modifyTime;
    private Date lastLoginTime;
    private String sex;
    private String theme;
    private String avatar;
    private String description;
    private String roleName;

}
