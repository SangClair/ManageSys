package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4055466638143028277L;
	private Integer id;
	private String categoryName;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser = "admin";
	private String modifiedUser = "admin";
	private Integer parentId;
}
