package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysBrand implements Serializable{

	private static final long serialVersionUID = -8605597862818372939L;
	
	private Integer id;
	private String corporatename;
	private String addr;
	private String tel;
	private Date createdTime;
	private Date endTime;

	

}
