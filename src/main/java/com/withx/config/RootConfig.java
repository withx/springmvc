package com.withx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.withx.service"})
@Import({JdbcConfig.class,MybatisConfig.class, SecurityInit.class, SecurityConfig.class})
@PropertySource("classpath:config/root.properties")
@EnableTransactionManagement
public class RootConfig {
}
