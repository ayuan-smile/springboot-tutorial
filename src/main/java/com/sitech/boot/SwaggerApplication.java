package com.sitech.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.base.Predicate;
import springfox.documentation.builders.PathSelectors;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	@Bean
	public Docket createRestApi() {
		Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				Class<?> clazz = input.declaringClass();
				if (clazz == BasicErrorController.class) {
					return false;
				}
				if (clazz.isAnnotationPresent(RestController.class)) {
					return true;
				}
				if (input.isAnnotatedWith(ResponseBody.class)) {
					return true;
				}
				return false;
			}
		};
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).useDefaultResponseMessages(false).select()
				.apis(predicate).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Electronic Health Record(EHR) Platform API")// 大标题
				.description(
						"EHR Platform's REST API, all the applications could access the Object model data via JSON.")// 详细描述
				.version("1.0")// 版本
				.termsOfServiceUrl("NO terms of service")
				.contact(new Contact("小小", "http://blog.csdn.net", "1212@qq.com"))// 作者
				.license("The Apache License, Version 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").build();
	}

	@Bean
	public Docket module1Api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("module1")
				.genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).forCodeGeneration(true)
				.pathMapping("/")// base，最终调用接口后会和paths拼接在一起
				.select().paths(PathSelectors.regex("/api/test/show1.*"))// 过滤的接口
				.build().apiInfo(module1ApiInfo());
	}

	@Bean
	public Docket module2Api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("module2")
				.genericModelSubstitutes(DeferredResult.class)
				// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).forCodeGeneration(false).pathMapping("/").select()
				.paths(PathSelectors.regex("/api/test/show2.*"))// 过滤的接口
				.build().apiInfo(module2ApiInfo());
	}

	private ApiInfo module1ApiInfo() {
		return new ApiInfoBuilder().title("Electronic Health Record(EHR) Platform API")// 大标题
				.description(
						"EHR Platform's REST API, all the applications could access the Object model data via JSON.")// 详细描述
				.version("1.0")// 版本
				.termsOfServiceUrl("NO terms of service")
				.contact(new Contact("小小", "http://blog.csdn.net", "1212@qq.com"))// 作者
				.license("The Apache License, Version 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").build();
	}

	private ApiInfo module2ApiInfo() {
		return new ApiInfoBuilder().title("Electronic Health Record(EHR) Platform API")// 大标题
				.description(
						"EHR Platform's REST API, all the applications could access the Object model data via JSON.")// 详细描述
				.version("1.0")// 版本
				.termsOfServiceUrl("NO terms of service")
				.contact(new Contact("小小", "http://blog.csdn.net", "1212@qq.com"))// 作者
				.license("The Apache License, Version 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").build();
	}
}
