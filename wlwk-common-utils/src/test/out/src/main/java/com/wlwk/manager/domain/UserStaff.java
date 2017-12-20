package com.wlwk.manager.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class UserStaff implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields pk_id : 主键
	 */
	@ApiModelProperty(name = "pkId", notes = "主键")
	private String pkId;
	/**
	 * @Fields create_user : 创建用户
	 */
	@ApiModelProperty(name = "createUser", notes = "创建用户")
	private String createUser;
	/**
	 * @Fields create_time : 创建时间
	 */
	@ApiModelProperty(name = "createTime", notes = "创建时间")
	private Date createTime;
	/**
	 * @Fields update_user : 更新用户
	 */
	@ApiModelProperty(name = "updateUser", notes = "更新用户")
	private String updateUser;
	/**
	 * @Fields update_time : 更新时间
	 */
	@ApiModelProperty(name = "updateTime", notes = "更新时间")
	private Date updateTime;
	/**
	 * @Fields del_mark : 删除标识(--1正常--2已删除)
	 */
	@ApiModelProperty(name = "delMark", notes = "删除标识(--1正常--2已删除)")
	private Integer delMark;
	/**
	 * @Fields org_id : 组织ID
	 */
	@ApiModelProperty(name = "orgId", notes = "组织ID")
	private String orgId;
	/**
	 * @Fields staff_id : 员工ID
	 */
	@ApiModelProperty(name = "staffId", notes = "员工ID")
	private String staffId;
	/**
	 * @Fields staff_name : 员工名称
	 */
	@ApiModelProperty(name = "staffName", notes = "员工名称")
	private String staffName;
	/**
	 * @Fields staff_type : 员工类型(--1管理系统--2客户平台)
	 */
	@ApiModelProperty(name = "staffType", notes = "员工类型(--1管理系统--2客户平台)")
	private Integer staffType;
	
	@Override
    public String toString() {
        return  "UserStaff " + 
                    "[pkId=" + pkId + "]"
                   + ",[createUser=" + createUser + "]"
                   + ",[createTime=" + createTime + "]"
                   + ",[updateUser=" + updateUser + "]"
                   + ",[updateTime=" + updateTime + "]"
                   + ",[delMark=" + delMark + "]"
                   + ",[orgId=" + orgId + "]"
                   + ",[staffId=" + staffId + "]"
                   + ",[staffName=" + staffName + "]"
                   + ",[staffType=" + staffType + "]"
                ;
    }
}

