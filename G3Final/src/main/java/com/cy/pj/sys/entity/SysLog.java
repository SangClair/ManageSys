package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * POJO:(普通JAVA对象)
 * 1) PO:持久化对象,与表中字段有映射关系
 * 2) VO:值对象,用于封装业务数据,可能在层与层之间传递
 * @author soft01
 *
 */
@Data
public class SysLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8924387722922123121L;
	/**
	 * 
	 */
	private Integer id;
	private String username;
	private String operation;
	private String method;
	private String params;
	private Long time;
	private String ip;
	private Date createdTime;
}
