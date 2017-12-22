package com.coymaple.spring.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class JsonConverter {
	
	@Resource
	MappingJackson2HttpMessageConverter jacksonMessageConverter;
	
	@Resource
	FastJsonHttpMessageConverter fastJsonMessageConverter;
	
	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		MappingJackson2HttpMessageConverter mj2hmc = new MappingJackson2HttpMessageConverter();
		List<MediaType> list = new ArrayList<>();
		list.add(MediaType.APPLICATION_JSON_UTF8);
		mj2hmc.setSupportedMediaTypes(list);
		return mj2hmc;
	}
	
	@Bean
	public FastJsonHttpMessageConverter fastJsonMessageConverter() {
		FastJsonHttpMessageConverter fjhmc = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(MediaType.APPLICATION_JSON_UTF8);
		fjhmc.setSupportedMediaTypes(list);
		fjhmc.setFastJsonConfig(fastJsonConfig);
		return fjhmc;
	}
}
