package com.shl.onetest.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:songhongli
 * @Created: 2018/7/13
 */
@Data
public class Dict implements Serializable {
    private static final long serialVersionUID = 7780820231535870010L;
    private Long dictId;
    private String keyy;
    private String valuee;
    private String tableName;
    private String fieldName;
}
