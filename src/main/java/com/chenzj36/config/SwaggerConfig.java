package com.chenzj36.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/2/8 11:38
 * @Description Swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    @Bean
    public Docket docket(Environment environment){
        Profiles profiles = Profiles.of("dev","test");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 选择是否启用swagger
                .enable(flag)
                .groupName("chenzj36")
                .select()
                // RequestHandlerSelectors配置要扫描接口的方式
                // basePackage指定要扫描的包
                // any：扫描全部
                // none：都不扫描
                // withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                // withMethodAnnotation：扫描方法上的注解 s.withMethodAnnotation(RestController.class)
                .apis(RequestHandlerSelectors.basePackage("com.chenzj36.controller"))
                // path：过滤哪些路径
//                .paths(PathSelectors.ant("/chenzj36/**"))
                .build();
    }

    //配置swagger信息apiInfo
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("Danny Lyons", "https://github.com/chenzj36", "chenzj36@live.cn");
        return new ApiInfo( //对应/swagger-ui.html首页的显示
                "chenzj36 Documentation",
                "即使再小的饭也能远航",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
