package com.payment.generator;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/payment-plan-generate.*"), regex("/payment-plan-generate.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Payment Plan Application for borrowers")
				.description("API will be used for calculate the payment plan of borrowers on basis of no of days.")
				.termsOfServiceUrl("http://xyz.com")
				.contact("raj.kumar.upadhyay@xyz.com").license("License")
				.licenseUrl("www.xyz.com").version("1.0").build();
	}
}

