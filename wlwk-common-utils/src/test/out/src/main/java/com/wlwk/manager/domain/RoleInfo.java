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
public class RoleInfo implements Serializable {
	
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
	 * @Fields role_name : 角色名称
	 */
	@ApiModelProperty(name = "roleName", notes = "角色名称")
	private String roleName;
	/**
	 * @Fields remark : 角色备注
	 */
	@ApiModelProperty(name = "remark", notes = "角色备注")
	private String remark;
	/**
	 * @Fields role_type : 角色类型(--1系统--2自定义)
	 */
	@ApiModelProperty(name = "roleType", notes = "角色类型(--1系统--2自定义)")
	private Integer roleType;
	
	@Override
    public String toString() {
        return  "RoleInfo " + 
                    "[pkId=" + pkId + "]"
                   + ",[createUser=" + createUser + "]"
                   + ",[createTime=" + createTime + "]"
                   + ",[updateUser=" + updateUser + "]"
                   + ",[updateTime=" + updateTime + "]"
                   + ",[delMark=" + delMark + "]"
                   + ",[orgId=" + orgId + "]"
                   + ",[roleName=" + roleName + "]"
                   + ",[remark=" + remark + "]"
                   + ",[roleType=" + roleType + "]"
                ;
    }
}

