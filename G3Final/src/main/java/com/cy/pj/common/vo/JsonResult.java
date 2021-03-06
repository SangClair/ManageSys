package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 677048178703375661L;

	private Object data;
	private int state = 1;
	private String message = "ok";

	public JsonResult() {}
	public JsonResult(String message){
		this.message=message;
	}
	
	/**一般查询时调用，封装查询结果*/
	public JsonResult(Object data) {
		this.data=data;
	}
	
	/**出现异常时时调用*/
	public JsonResult(Throwable t){
		this.state=0;
		this.message=t.getMessage();
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
}
