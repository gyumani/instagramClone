package com.devjaws.instagramclone.utils.cookie;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class CookieUtil {
	public static String getCookie(HttpServletRequest request, String name) {
		if (request.getCookies() == null) return null;

		var cookie = Arrays.stream(request.getCookies())
				.filter(c -> c.getName().equals(name) && !c.getValue().isEmpty())
				.findFirst();

		if (cookie.isEmpty()) return null;

		return cookie.get().getValue();
	}
}
