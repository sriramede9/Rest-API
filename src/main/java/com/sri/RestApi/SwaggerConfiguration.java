package com.sri.RestApi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	// got these two from APIINFO class and modified accordingly
	public static final Contact DEFAULT_CONTACT = new Contact("Sri Ram Ede", "sriremede9", "sriramede@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("API - User", "CRUD+RMM+EH+SWAGGER+CONTENT_NEGOTIATION",
			"1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final HashSet<String> Consumes_and_Produces = new HashSet(
			Arrays.asList("application/xml", "application/json"));

	@Bean
	public Docket getApi() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).consumes(Consumes_and_Produces)
				.produces(Consumes_and_Produces);
	}
}
