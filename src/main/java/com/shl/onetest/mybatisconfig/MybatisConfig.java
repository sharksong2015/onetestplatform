package com.shl.onetest.mybatisconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author songhongli
 **/
@Configuration
@MapperScan(basePackages = {"com.shl.onetest.mapper"})
public class MybatisConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        System.err.println("dddd:"+druidDataSource==null);
        return druidDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

            String typeAliasesPackage = "com.shl.onetest.mapper";
            String mapperLocations = "classpath:mapper/*.xml";

            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(druidDataSource());
            factoryBean.setTypeAliasesPackage(typeAliasesPackage);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));

            return factoryBean.getObject();
    }
    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource druidDataSource) throws Exception {
        return new DataSourceTransactionManager(druidDataSource);
    }
}
