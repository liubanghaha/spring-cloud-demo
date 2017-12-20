package com.wlwk.oauth2.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields pk_id : 主键
	 */
	private String pkId;
	/**
	 * @Fields create_user : 创建用户
	 */
	private Long createUser;
	/**
	 * @Fields create_time : 创建时间
	 */
	private Date createTime;
	/**
	 * @Fields update_user : 更新用户
	 */
	private Long updateUser;
	/**
	 * @Fields update_time : 更新时间
	 */
	private Date updateTime;
	/**
	 * @Fields del_mark : 删除标识(--1正常--2已删除)
	 */
	private Integer delMark;
	/**
	 * @Fields login_name : 用户名
	 */
	private String loginName;
	/**
	 * @Fields login_pwd : 密码
	 */
	private String loginPwd;
	/**
	 * @Fields status : 用户状态(--1正常--2冻结)
	 */
	private Integer status;
}

