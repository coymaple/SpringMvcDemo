package com.coymaple.spring.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.druid.pool.DruidDataSource;


@Configuration
@ComponentScan(basePackages = {"com.coymaple"},excludeFilters= {@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound=true)
//@PropertySource(value= {"jdbc.properties"},ignoreResourceNotFound=true)
@EnableTransactionManagement
public class AppConfig {
	
	@Resource
	private Environment environment;
	@Resource
	private DataSource driverManagerDataSource;
	
	@Bean(name= {"driverManagerDataSource"})
	public DriverManagerDataSource driverManagerDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(environment.getProperty("jdbc.className"));
		dmds.setUrl(environment.getProperty("jdbc.url"));
		dmds.setUsername(environment.getProperty("jdbc.userName"));
		dmds.setPassword(environment.getProperty("jdbc.password"));
		return dmds;
	}
	
	@Bean
	public DruidDataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		
		return druidDataSource;
	}
	
	@Bean()
	public DataSourceTransactionManager txManager() {
		DataSourceTransactionManager dstm = new DataSourceTransactionManager(driverManagerDataSource);
		return dstm;
	}
	
	@Bean()
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
		return jdbcTemplate;
	}
}


