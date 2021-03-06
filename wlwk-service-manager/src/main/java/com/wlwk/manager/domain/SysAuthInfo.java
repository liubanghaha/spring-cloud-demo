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
public class SysAuthInfo implements Serializable {
	
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
	 * @Fields auth_code : 授权码
	 */
	@ApiModelProperty(name = "authCode", notes = "授权码")
	private String authCode;
	/**
	 * @Fields remark : 授权码描述
	 */
	@ApiModelProperty(name = "remark", notes = "授权码描述")
	private String remark;
	/**
	 * @Fields auth_type : 类型(--1管理系统--2客户平台)
	 */
	@ApiModelProperty(name = "authType", notes = "类型(--1管理系统--2客户平台)")
	private Integer authType;
	
	@Override
    public String toString() {
        return  "SysAuthInfo " + 
                    "[pkId=" + pkId + "]"
                   + ",[createUser=" + createUser + "]"
                   + ",[createTime=" + createTime + "]"
                   + ",[updateUser=" + updateUser + "]"
                   + ",[updateTime=" + updateTime + "]"
                   + ",[delMark=" + delMark + "]"
                   + ",[authCode=" + authCode + "]"
                   + ",[remark=" + remark + "]"
                   + ",[authType=" + authType + "]"
                ;
    }
}

