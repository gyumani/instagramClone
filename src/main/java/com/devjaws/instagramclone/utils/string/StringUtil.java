package com.devjaws.instagramclone.utils.string;

import java.util.regex.Pattern;

public class StringUtil {
	public static String toCamel(String str) {
		return Pattern.compile("[_\\-][a-zA-Z]").matcher(str.toLowerCase()).replaceAll(s -> s.group().replaceAll("[_\\-]", "").toUpperCase());
	}
}
