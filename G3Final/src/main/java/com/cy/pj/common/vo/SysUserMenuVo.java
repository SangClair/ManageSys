package com.cy.pj.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class SysUserMenuVo {

	private Integer id;
	private String name;
	private String url;
	private List<SysUserMenuVo> children;
}
