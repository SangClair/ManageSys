package com.cy.common.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysLogService;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class SysLogAspect {

	@Autowired
	SysLogService sysLogService;

	@Pointcut("@annotation(com.cy.common.aspect.RequiredLog)")
	public void logPointCut() {

	}


	@Around("logPointCut()")
	public Object saveLog(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			Object methodResult = jp.proceed();
			long end = System.currentTimeMillis();
			saveLog(jp, end - start);
			return methodResult;
		} catch(Throwable e) {
			log.error("error {}", e.getMessage());
			throw e;
		}
	}


	private void saveLog(ProceedingJoinPoint jp, long time) throws NoSuchMethodException, SecurityException {
		Class<?> cls = jp.getTarget().getClass();
		MethodSignature ms= (MethodSignature) jp.getSignature();
		Method m = cls.getMethod(ms.getName(), ms.getParameterTypes());
		String operation = m.getAnnotation(RequiredLog.class).operation();
		SysLog log=new SysLog();
		String targetClsMethod = cls.getName() + "." + ms.getName();
		String params = Arrays.toString(jp.getArgs());
		ServletRequestAttributes ra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest hsr = ra.getRequest();
		String ip = hsr.getRemoteHost();
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		String username = sysUser.getUsername();
		log.setIp(ip);
		log.setUsername(username);
		log.setOperation(operation);
		log.setMethod(targetClsMethod);//目标方法:类全名+方法名
		log.setParams(params);//目标方法实际参数:
		log.setTime(time);
		log.setCreatedTime(new Date());
		//3.写日志
		sysLogService.saveObject(log);
	}
}
