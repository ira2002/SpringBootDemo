package com.example.springBootDemo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2
 * 	通过@Configuration注解，让Spring来加载该类配置。再通过@EnableSwagger2注解来启用Swagger2。
 * 	再通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
 * 	select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，本例采用指定扫描的包路径来定义，
 * 	Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
 * 
 * 	在完成了上述配置后，其实已经可以生产文档内容，但是这样的文档主要针对请求本身，而描述主要来源于函数等命名产生，
 * 	对用户并不友好，我们通常需要自己增加一些说明来丰富文档内容。如下所示，我们通过@ApiOperation注解来给API增加说明、
 * 	通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明。
 * 
 * 	@Api：修饰整个类，描述Controller的作用
	@ApiOperation：描述一个类的一个方法，或者说一个接口
	@ApiParam：单个参数描述
	@ApiModel：用对象来接收参数
	@ApiProperty：用对象接收参数时，描述对象的一个字段
	@ApiResponse：HTTP响应其中1个描述
	@ApiResponses：HTTP响应整体描述
	@ApiIgnore：使用该注解忽略这个API
	@ApiError ：发生错误返回的信息
	@ApiParamImplicitL：一个请求参数
	@ApiParamsImplicit 多个请求参数
	
 * @author	chdaba
 * @version	1.0.0
 * @date	2018年12月24日 下午3:19:35
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	
	    @Bean
	    public Docket createRestApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.example.springBootDemo.controller"))
	                .paths(PathSelectors.any())
	                .build();
	    }
	    
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Spring Boot中使用Swagger2构建RESTful APIs")
	                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
	                .termsOfServiceUrl("http://localhost:8080")
	                .contact(new Contact("chdaba", null, null))
	                .version("1.0.0")
	                .build();
	    }
}
