package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.cy.pj.sys.entity.SysDept;

import lombok.Data;

@Data
public class SysUserDeptVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6661196009381010823L;
	private Integer id;
	private String username;
	private String password;
	private String salt;
	private String email;
	private String mobile;
	private Integer valid;
	private Integer deptID;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	private SysDept sysDept;
}
