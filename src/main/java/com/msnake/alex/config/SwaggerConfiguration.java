package com.msnake.alex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger - конфигурация
 *
 * @author shigaevak
 * @since 29.05.2017
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Документация API
     *
     * @return - документация API
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.msnake.alex.controller"))
                .paths(PathSelectors.regex("/v1/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Информация об API
     *
     * @return - информация об API
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringFox Example API")
                .description("API RESTFull service")
                .version("1.0.0")
                .termsOfServiceUrl("https://github.com/MSnake")
                .license("MSnake")
                .licenseUrl("https://github.com/MSnake")
                .build();
    }
}