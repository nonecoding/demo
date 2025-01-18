package com.example.demo.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Slf4j
public class Knife4jConfig {
    @Value("${server.port}")
    private int port;
    
    @Bean
    public Docket createRestApi() {
        // 输出 Swagger UI 地址
        log.info("Swagger UI is available at: http://localhost:{}/doc.html#/home", getPort());
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Documentation")
                .description("API Documentation for Your Project")
                .contact(new Contact("Your Name", "", "your.email@example.com"))
                .version("1.0")
                .build();
    }

    // 获取当前应用的端口
    private int getPort() {
        // 这里可以根据实际情况获取端口号
        // 例如，可以通过环境变量或配置文件获取
        return port; // 默认端口
    }
}
