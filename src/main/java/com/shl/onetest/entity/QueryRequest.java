package com.shl.onetest.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:songhongli
 * @Created: 2018/7/11
 */
@Data
public class QueryRequest implements Serializable {
    private static final long serialVersionUID = -4869594085374385813L;
    private int pageSize;
    private int pageNum;
}
