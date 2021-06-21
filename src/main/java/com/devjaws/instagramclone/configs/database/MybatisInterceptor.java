package com.devjaws.instagramclone.configs.database;

import lombok.var;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Stream;

@Component
@Intercepts({
        @Signature(type = Executor.class, method = "query", args={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class MybatisInterceptor implements Interceptor {
    private final Logger logger= LoggerFactory.getLogger(MybatisInterceptor.class);
    String[] ignoreSqls={""};


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        var statement=(MappedStatement) invocation.getArgs()[0];
        var mapperId=statement.getId();
        if(Arrays.stream(ignoreSqls).noneMatch(sql ->sql.equals(mapperId))){
            var boundsql=statement.getBoundSql(invocation.getArgs()[1]);
            logger.info("MAPPER.ID=====>{}\n SQL :: {}",mapperId, makeLog(boundsql));
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) { return Interceptor.super.plugin(target);}

    @Override
    public void setProperties(Properties properties) { Interceptor.super.setProperties(properties); }

    private String makeLog(BoundSql boundsql) {
        var sql=boundsql.getSql();
        var param=boundsql.getParameterObject();
        if(param != null){
            var paramClass=param.getClass();
            var isMapping=Stream.of(Integer.class, Float.class, Double.class, Boolean.class, Long.class, String.class, Short.class)
                    .noneMatch(str->str.equals(paramClass));

            if(isMapping){
                var params=boundsql.getParameterMappings();
                try{
                    for(var mapping: params){
                        var filed=paramClass.getDeclaredField(mapping.getProperty());
                        filed.setAccessible(true);
                        sql=sql.replaceFirst("\\?","'"+filed.get(param)+"'");
                    }
                }catch(Exception ignore){

                }
            }else{
                sql=sql.replaceFirst("\\?","'"+param+"'");
            }
        }
        sql=sql.replaceAll("\n[ \\t\\x0b\\r\\f]\n","\n");
        return sql;
    }



}
