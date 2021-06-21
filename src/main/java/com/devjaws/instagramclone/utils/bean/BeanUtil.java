package com.devjaws.instagramclone.utils.bean;

import kr.co.kbz.utils.string.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.util.HashMap;

public class BeanUtil {
	public static <T> T beansCopy(Object source, Class<T> clz) {
		try {
			var c = Class.forName(clz.getName()).asSubclass(clz);
			var obj = c.getConstructor().newInstance();
			beanCopy(obj, source);
			return clz.cast(obj);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	public static <T> T beansCopy(HashMap<String, Object> source, Class<T> clz) {
		try {
			var c = Class.forName(clz.getName()).asSubclass(clz);
			var obj = c.getConstructor().newInstance();
			checkBeanNull(obj, source);

			for (String key : source.keySet()) {
				if (isWriteable(StringUtil.toCamel(key), obj)) {
					PropertyUtils.setProperty(obj, StringUtil.toCamel(key), source.get(key));
				} else if (isWriteable(key, obj)) {
					PropertyUtils.setProperty(obj, key, source.get(key));
				}
			}
			return clz.cast(obj);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	private static void beanCopy(Object target, Object source) {
		checkBeanNull(target, source);
		writeBeanToBean(target, source);
	}

	private static void checkBeanNull(Object target, Object source) {
		if (target == null || source == null) throw new IllegalArgumentException("sourceObject/targetObject is null!");
	}

	private static void writeBeanToBean(Object target, Object source) {
		var pds = PropertyUtils.getPropertyDescriptors(source);
		for (PropertyDescriptor pd : pds) {
			var propName = pd.getName();
			if (isWriteable(propName, target) && isReadable(propName, source)) {
				try {
					PropertyUtils.setProperty(target, propName, PropertyUtils.getProperty(source, propName));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	private static boolean isReadable(String propName, Object obj) {
		return PropertyUtils.isReadable(obj, propName);
	}

	private static boolean isWriteable(String propName, Object obj) {
		return PropertyUtils.isWriteable(obj, propName);
	}
}