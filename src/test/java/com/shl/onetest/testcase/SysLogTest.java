package com.shl.onetest.testcase;

import com.shl.onetest.domain.SysLog;
import com.shl.onetest.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * @Author:songhongli
 * @Created: 2018/7/11
 */
@SpringBootTest
public class SysLogTest extends AbstractTestNGSpringContextTests{
    @Autowired
    SysLogService sysLogService;

    @Test
    public void testInsert(){
        SysLog sysLog = new SysLog();
        sysLog.setUsername("scott");
        sysLog.setMethod("test");
        sysLog.setCreateTime(new Date());
        sysLog.setOperation("eee");
        sysLogService.recordSysLog(sysLog);
    }

}
