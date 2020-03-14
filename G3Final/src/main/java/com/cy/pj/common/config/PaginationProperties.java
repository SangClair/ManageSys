package com.cy.pj.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration//描述此类为配置类， 交给Spring管理
@ConfigurationProperties(prefix = "page.config")//告诉springboot读取配置文件中指定前缀的内容
@Setter
@Getter
public class PaginationProperties {
	
	private Integer pageSize=5;//set方法必须有
	
	public Integer startIndex(Integer pageCurrent) {
		  return (pageCurrent-1)*pageSize;
		 }
}
