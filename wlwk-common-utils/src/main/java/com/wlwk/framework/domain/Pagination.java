package com.wlwk.framework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
public class Pagination<E> extends AjaxReturn {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8426528464623224135L;
	@ApiModelProperty("总行数")
	private java.lang.Long total;
	@ApiModelProperty("数据行")
	private java.util.Collection<E> rows;

	public Pagination(){
		this.code = SUCCESS;
		this.info = "";
		this.data = "";
	}

	public Pagination(Long total, Collection<E> rows) {
		this.code = SUCCESS;
		this.info = "";
		this.data = "";
		this.total = total;
		this.rows = rows;
	}

}