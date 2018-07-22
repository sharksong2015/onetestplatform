package com.shl.onetest.service;

import com.shl.onetest.domain.SysLog;
import com.shl.onetest.mapper.SysLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:songhongli
 * @Created: 2018/7/10
 */
@Service
public class SysLogService {
    @Autowired
    SysLogMapper sysLogMapper;

    public void recordSysLog(SysLog sysLog){
        sysLogMapper.recordSysLog(sysLog);
    }

}
