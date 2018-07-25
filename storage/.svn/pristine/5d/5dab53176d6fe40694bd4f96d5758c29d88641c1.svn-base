package com.hywa.bigdata.storage.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class TaskNodeInfo {

    private String id;

    @NotNull(message = "节点名称不能为空")
    @Size(min=0,message ="节点名称不能为空" )
    private String name;

    private Integer isShow;

    private String department;

    @NotNull(message = "步骤类型不能为空")
    @Min(value = 0,message = "步骤类型参数有误")
    @Max(value = 1,message = "步骤类型参数有误")
    private Integer stepType;

    @NotNull(message = "所属菜单位置不能为空")
    @Size(min=0,message ="所属菜单位置不能为空" )
    private String menuPosition;

    private String assignee;

    private String remark;

    @NotNull(message = "节点排序值不能为空")
    private Integer sort;

    @NotNull(message = "流程id不能为空")
    @Size(min=0,message ="流程id不能为空" )
    private String processId;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;
    
    private String menuName;

}