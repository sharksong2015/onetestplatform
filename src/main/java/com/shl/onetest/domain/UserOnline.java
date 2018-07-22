package com.shl.onetest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:songhongli
 * @Created: 2018/7/13
 */
@Data
public class UserOnline implements Serializable {
    private static final long serialVersionUID = 3828664348416633856L;

    private String id;

    private String userId;

    private String username;

    private String host;

    private String systemHost;

    private String status;

    private Date startTimestamp;

    private Date lastAccessTime;

    private Long timeout;

    private String location;
}
