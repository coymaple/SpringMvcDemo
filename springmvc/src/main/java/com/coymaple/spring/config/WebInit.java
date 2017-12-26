package com.coymaple.spring.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInit implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AppConfig.class,MvcConfig.class,JsonConverterConfig.class);
		applicationContext.setServletContext(servletContext);
		
		FilterRegistration.Dynamic charFilter=servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
		charFilter.setInitParameter("encoding","utf-8");
		charFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.ASYNC), false, "*.mvc");
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext)); 
		//addMapping() 设置拦截的...，"/" 是所有的都拦截。
		servlet.addMapping("*.mvc");
		servlet.setLoadOnStartup(1);
	}

}
