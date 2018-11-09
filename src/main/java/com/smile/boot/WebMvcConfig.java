package com.smile.boot;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration

/**   
 * @Title: WebMvcConfig
 * @Description: SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
 * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义
 * 重写该方法需要 extends WebMvcConfigurerAdapter 
 * @author 阿袁 yuanxm@si-tech.com.cn
 */
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	*/
}
