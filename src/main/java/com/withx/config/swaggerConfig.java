package com.withx.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class swaggerConfig {
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("00 All KIOSK Device API")
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.withx.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(SecuritySchemes())
                .securityContexts(SecurityContexts())
                ;
    }

    @Value("${api.title}")
    private String  title;
    @Value("${api.description}")
    private String  description;
    @Value("${api.terms}")
    private String  terms;
    @Value("${api.license}")
    private String  license;
    @Value("${api.licenseUrl}")
    private String  licenseUrl;
    @Value("${api.version}")
    private String  version;

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(terms)
                .license(license)
                .licenseUrl(licenseUrl)
                .version(version)
                .build();
    }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global","basicAuth");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] =authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }
    private List<SecurityScheme> SecuritySchemes() {
        List<SecurityScheme> list =  new ArrayList<>();
        list.add(new BasicAuth("basicAuth"));
        list.add(new ApiKey("write_token","write_token","header"));
        list.add(new ApiKey("read_token","read_token","query"));
        list.add(new ApiKey("x-auth-token", "x-auth-token", "header"));

        return list;
    }
    private List<SecurityContext> SecurityContexts() {
        return  Arrays.asList(
            SecurityContext
                .builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build()
        );
    }
}
