package kr.hyundai.oneid.config;
import kr.hyundai.oneid.properties.SwaggerProperties;

import com.google.common.base.Predicate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Slf4j
@EnableConfigurationProperties({SwaggerProperties.class})
public class SwaggerConfig {

    @Autowired
    SwaggerProperties swaggerProperties;

    @Bean
    public ApiInfo apiInfo() {
        StopWatch watch = new StopWatch();
        watch.start();
        springfox.documentation.service.ApiInfo apiInfo = new springfox.documentation.service.ApiInfo("", "", "", "", "", "", "");

        watch.stop();
        return apiInfo;
    }


    @Bean
    public Docket payApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .forCodeGeneration(true)
                .groupName("Pay 관련")
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .select()
                .paths(payPaths())
                .build();
    }

    private Predicate<String> payPaths() {
        return or(
                regex("/*.*")
        );
    }
}