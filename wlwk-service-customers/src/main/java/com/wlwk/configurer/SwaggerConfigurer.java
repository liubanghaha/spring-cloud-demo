package com.wlwk.configurer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnClass(springfox.documentation.spring.web.plugins.Docket.class)
public class SwaggerConfigurer {
    
    @Bean("docket1")
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("goods").select().paths(PathSelectors.regex("/goods\\-.*")).build();
    }
}
