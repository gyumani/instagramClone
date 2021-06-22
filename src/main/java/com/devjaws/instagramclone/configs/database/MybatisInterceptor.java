package com.devjaws.instagramclone.configs.database;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

@Component
@Intercepts({
		@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
})
public class MybatisInterceptor implements Interceptor {
	private final Logger logger = LoggerFactory.getLogger(MybatisInterceptor.class);
	String[] ignoreSqls = {""};

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
		String mapperId = statement.getId();
		if (Arrays.stream(ignoreSqls).noneMatch(sql -> sql.equals(mapperId))) {
			BoundSql boundSql = statement.getBoundSql(invocation.getArgs()[1]);
			logger.info("MAPPER.ID ====> {}\n SQL :: {}", mapperId, makeLog(boundSql));
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Interceptor.super.plugin(target);
	}

	@Override
	public void setProperties(Properties properties) {
		Interceptor.super.setProperties(properties);
	}

	private String makeLog(BoundSql boundSql) {
		String sql = boundSql.getSql();
		Object param = boundSql.getParameterObject();
		if (param != null) {
			Class<?> paramClass = param.getClass();
			// 아래 열거된 형태가 아닌경우 true
			boolean isMapping = Stream.of(Integer.class, Float.class, Double.class, Boolean.class, Long.class, String.class, Short.class)
					.noneMatch(str -> str.equals(paramClass));

			if (isMapping) {
				// 매핑할 리스트들을 불러온다
				List<ParameterMapping> params = boundSql.getParameterMappings();
				try {
					for (ParameterMapping mapping : params) {
						// Class 안의 Field
						Field filed = paramClass.getDeclaredField(mapping.getProperty());
						// 접근제어자가 protected, private 이라도 접근 가능하게 함.
						filed.setAccessible(true);
						sql = sql.replaceFirst("\\?", "'" + filed.get(param) + "'");
					}
				} catch (Exception ignore) {
				}
			} else {
				sql = sql.replaceFirst("\\?", "'" + param + "'");
			}
		}
		sql = sql.replaceAll("\n[ \\t\\x0b\\r\\f]\n", "\n");
		return sql;
	}
}
