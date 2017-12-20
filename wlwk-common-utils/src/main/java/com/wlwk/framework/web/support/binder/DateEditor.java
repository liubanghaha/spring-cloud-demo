package com.wlwk.framework.web.support.binder;

import java.beans.PropertyEditorSupport;

import com.wlwk.framework.utils.DateFormatUtils;

public class DateEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(DateFormatUtils.parse(text));
	}
}