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
public class UserAccount implements Serializable {
	
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
	 * @Fields login_name : 用户名
	 */
	@ApiModelProperty(name = "loginName", notes = "用户名")
	private String loginName;
	/**
	 * @Fields login_pwd : 密码
	 */
	@ApiModelProperty(name = "loginPwd", notes = "密码")
	private String loginPwd;
	/**
	 * @Fields status : 用户状态(--1正常--2冻结)
	 */
	@ApiModelProperty(name = "status", notes = "用户状态(--1正常--2冻结)")
	private Integer status;
	
	@Override
    public String toString() {
        return  "UserAccount " + 
                    "[pkId=" + pkId + "]"
                   + ",[createUser=" + createUser + "]"
                   + ",[createTime=" + createTime + "]"
                   + ",[updateUser=" + updateUser + "]"
                   + ",[updateTime=" + updateTime + "]"
                   + ",[delMark=" + delMark + "]"
                   + ",[loginName=" + loginName + "]"
                   + ",[loginPwd=" + loginPwd + "]"
                   + ",[status=" + status + "]"
                ;
    }
}

