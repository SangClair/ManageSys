package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Node implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7452725282288154120L;
	Integer id;
	String name;
	Integer parentId;
	
}
