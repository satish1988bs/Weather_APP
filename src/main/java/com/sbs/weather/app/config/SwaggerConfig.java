package com.sbs.weather.app.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;
import java.util.List;

@EnableSwagger2
@Configuration
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter{
//	http://localhost:8083/weatherapi/v2/api-docs
    @Bean
    public Docket exampleApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sbs.weather"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    }
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Weather API",
                "Weather Api Creator",
                "1.0",
                "Terms of Service",
                new Contact("Satish Balu Sutar", "https://github.com/SatishSutar",
                        "s1a9i88@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", Collections.EMPTY_LIST
        );

        return apiInfo;
    }
}