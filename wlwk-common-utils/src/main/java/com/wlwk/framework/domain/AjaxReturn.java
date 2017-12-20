package com.wlwk.framework.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
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
public class AjaxReturn implements Serializable {

	public final static int SUCCESS = 200;

	/**
	 *
	 */
	private static final long serialVersionUID = 1951072383754672530L;

	@ApiModelProperty("响应编码")
	@Builder.Default
	protected java.lang.Integer code = SUCCESS;

	@ApiModelProperty("响应信息")
	@Builder.Default
	protected java.lang.String info = "";

	@ApiModelProperty("响应数据")
	@Builder.Default
	protected java.lang.Object data = "";

}
