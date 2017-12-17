package kr.hyundai.oneid.config;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
// @EnableWebMvc
// @ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }


//   @Bean
//   public ServletContextTemplateResolver templateResolver() {
//     ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
//     resolver.setPrefix("/WEB-INF/templates/");
//     resolver.setSuffix(".html");
//     resolver.setTemplateMode("LEGACYHTML5");
//     resolver.setOrder(1);
//     return resolver;
// }

}
