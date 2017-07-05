package com.msnake.alex.config;

import org.springframework.beans.factory.annotation.Value;
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
     * APi end-point
     */
    @Value("springfox.documentation.swagger.v2.path")
    private String swagger2Endpoint;

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
                .paths(PathSelectors.any()) // PathSelectors.ant("/foos/*")) - Filtering API
//                .paths(PathSelectors.regex("/v1/.*")) // PathSelectors.ant("/foos/*")) - Filtering API
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
//                .useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.GET,
//                        new ArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("Внутренняя ошибка сервера")
////                                .responseModel(new ModelRef("Error"))
//                                .build(),
//                                new ResponseMessageBuilder()
//                                        .code(200)
//                                        .message("Запрос успешно обработан")
//                                        .build()));
    }

    /**
     * Информация об API
     *
     * @return - информация об API
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringFox Example API")
                .description("API RESTFull service " +
                        "Example SpringFox text \n" +
                        "Example SpringFox text \n" +
                        "Example SpringFox text \n" +
                        "Example SpringFox text \n" +
                        "Example SpringFox text \n" +
                        "Example SpringFox text \n" +
                        "Example SpringFox text")
                .version("1.0.0")
                .termsOfServiceUrl("https://github.com/MSnake")
                .license("MSnake")
                .licenseUrl("https://github.com/MSnake")
                .build();
    }
}