package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysProject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3345115646427567622L;
	private Integer id;
	private String name;
	private Integer parentId;
	private Integer price;
	private String minMembers;
	private String maxMembers;
	private Date createdDate;
	private Date updatedDate;
	private String resume;
}
