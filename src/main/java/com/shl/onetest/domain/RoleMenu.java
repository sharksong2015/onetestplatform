package com.shl.onetest.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:songhongli
 * @Created: 2018/7/13
 */
@Data
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = -7573904024872252113L;
    private Long roleId;
    private Long menuId;

}
