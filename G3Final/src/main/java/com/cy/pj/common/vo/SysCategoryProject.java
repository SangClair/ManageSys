package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.cy.pj.sys.entity.SysCategory;

import lombok.Data;

@Data
public class SysCategoryProject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1227418322515737846L;
	private Integer id;
	private String name;
	private Integer parentId;
	private Integer price;
	private String minMembers;
	private String maxMembers;
	private Date createdDate;
	private Date updatedDate;
	private String resume;
	private SysCategory sysCategory;
	
}
