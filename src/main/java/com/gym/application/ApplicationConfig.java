package com.gym.application;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Filter;
import java.util.logging.Logger;

@Configuration
public class ApplicationConfig {

    @Bean
    public Docket schoolApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("com.gym.controller")).
                paths(PathSelectors.any()).
                build().apiInfo(apiInfo());
    }

    @Bean
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Gym Customer Managemet API")
                .description("Gym customer management system to register users,update memberships,make group trainings and more.")
                .version("1.0")
                .build();
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {

        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();

        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");

        return filter;
    }

}
