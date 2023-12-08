package com.ecommerce.utils;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.apache.commons.lang3.StringUtils;

public class StringSpaceTrimmer extends StdConverter<String, String> {

	@Override
	public String convert(String value) {
		return StringUtils.isBlank(value) ? value : value.trim();
	}

}