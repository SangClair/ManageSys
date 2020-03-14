package com.cy.pj.sys.entity;

import lombok.Data;

@Data
public class SysTripGroup {
    private Integer id; //团目id
    private String projectName;//项目名称
    private String name;//团目名称
    private Integer groupNumber;//团队人数
    private String departure;//出发地
    private String destination;//终点地
    private String principal;//负责人
    private Integer fund;//总资金
    private String schedule;//进度地点
    private Integer projectId;
}
