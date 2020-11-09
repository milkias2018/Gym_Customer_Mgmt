package develop.gym.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ApplicationConfig {

    @Bean
    public Docket schoolApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("develop.gym.controller")).
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

}
