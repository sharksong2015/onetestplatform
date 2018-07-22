package com.shl.onetest.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shl.onetest.annotation.Log;
import com.shl.onetest.domain.SysLog;
import com.shl.onetest.domain.User;
import com.shl.onetest.service.SysLogService;
import com.shl.onetest.util.HttpContextUtils;
import com.shl.onetest.util.IPUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author:songhongli
 * @Created: 2018/7/10
 */
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.shl.onetest.annotation.Log)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws JsonProcessingException {
        Object result = null;
        long begin = System.currentTimeMillis();
        try {
            result = point.proceed();
            long time = System.currentTimeMillis() - begin;
            saveLog(point, time);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);

        if (null != log) {
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipal();
            SysLog sysLog = new SysLog();
            sysLog.setOperation(log.value());

            String className = joinPoint.getTarget().getClass().getName();
            String methodName = signature.getName();
            sysLog.setMethod(className + "." + methodName + "()");

            Object[] args = joinPoint.getArgs();
            LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
            String[] paramNames = u.getParameterNames(method);
            if (args != null && paramNames != null) {
                StringBuilder params = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    params.append("  ").append(paramNames[i]).append(": ").append(String.valueOf(args[i]));
                }
                sysLog.setParams(params.toString());
            }

            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
            sysLog.setIp(IPUtils.getIpAddr(request));
            sysLog.setUsername(user.getUsername());
            sysLog.setTime(time);
            sysLog.setLocation("ee");

            sysLogService.recordSysLog(sysLog);
        }


    }
}
