package com.withx.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan("com.withx.dao")
@EnableTransactionManagement
public class MybatisConfig {

    /*
     * dataSource1 --- Druid     DataSource
     * dataSource2 --- C3p0      DataSource
     * dataSource3 --- HikariCp  DataSource
     * dataSource2 --- Dbcp2     Datasource
     * */

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setMapperLocations(resolver.getResources("classpath:mapper/**/mapper-*.xml"));
        ssfb.setTypeAliasesPackage("com.withx.domain");
        ssfb.setDataSource(dataSource);

        return ssfb;
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
