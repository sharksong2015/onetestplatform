package com.shl.onetest.mapper;



import com.shl.onetest.domain.SysLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysLogMapper {
	public void recordSysLog(@Param("sysLog") SysLog sysLog);

}