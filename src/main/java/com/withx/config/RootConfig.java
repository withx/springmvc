package com.withx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan({"com.withx.service","com.withx.dao"})
public class RootConfig {
}
