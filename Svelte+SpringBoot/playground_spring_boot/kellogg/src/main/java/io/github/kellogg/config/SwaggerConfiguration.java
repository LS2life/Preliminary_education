package io.github.kellogg.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    
    @Bean
    // Docket : Swagger설정의 핵심이 되는 bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        // swagger ui로 노출할 정보
        .apiInfo(apiInfo())
        .select()
        // api 스펙이 작성되어 있는 패키지 (controller)를 지정.
        .apis(RequestHandlerSelectors.basePackage("io.github.killogg"))
        // apis 에 있는 api 중 특정 path를 선택
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title("My story Open API Test with Swagger")
        .description("설명서")
        .version("1.0.0")
        .build();
    }

    
}
