package com.wlwk.framework.web.support.binder;

import java.beans.PropertyEditorSupport;

import com.wlwk.framework.utils.NumberUtils;
import com.wlwk.framework.utils.StringUtils;

public class DoubleEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isNotBlank(text)) {
			setValue(NumberUtils.toDouble(text, 0.00));
		}
	}
}