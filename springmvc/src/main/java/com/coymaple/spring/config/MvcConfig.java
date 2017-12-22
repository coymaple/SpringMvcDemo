package com.coymaple.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.coymaple.web.controller"})
@EnableWebMvc
public class MvcConfig {
	
	//静态资源映射
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/upload/**").addResourceLocations("/upload/");
	}

	@Bean()
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver ubvr = new UrlBasedViewResolver();
		ubvr.setPrefix("/"); //设置前缀
		ubvr.setSuffix(".jsp"); //设置后缀
		ubvr.setViewClass(JstlView.class);
		return ubvr;
	}
}
