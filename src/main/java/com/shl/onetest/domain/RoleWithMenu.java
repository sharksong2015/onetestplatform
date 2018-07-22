package com.shl.onetest.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author:songhongli
 * @Created: 2018/7/13
 */
@Data
public class RoleWithMenu extends Role {
    private static final long serialVersionUID = 2013847071068967187L;
    private Long menuId;
    private List<Long> menuIds;
}
