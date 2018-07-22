package com.shl.onetest.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:songhongli
 * @Created: 2018/7/12
 */
@Data
public class UserRole implements Serializable {
    private static final long serialVersionUID = -3166012934498268403L;
    private Long userId;
    private Long roleId;

}
