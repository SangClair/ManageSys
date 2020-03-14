package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PageObject<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7014650230318618010L;
	private List<T> records;
	private Integer rowCount;
	private Integer pageCount;
	private Integer pageCurrent;
	private Integer pageSize = 3;
	
	public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.records  = records;
		this.rowCount = rowCount;
		this.pageCount = (rowCount - 1)/pageSize + 1;
	}
	public PageObject() {
		
	}
}
