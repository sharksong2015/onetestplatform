package com.shl.onetest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:songhongli
 * @Created: 2018/7/10
 */
@Data
public class SysLog implements Serializable {
    private static final long serialVersionUID = -8878596941954995444L;
    private Long id;
    private String username;
    private String operation;
    private Long time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
    private String location;
    private String timeField;

}
