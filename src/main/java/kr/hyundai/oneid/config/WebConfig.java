package kr.hyundai.oneid.config;

import org.springframework.context.annotation.Bean;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
// @EnableWebMvc
// @ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
  }

  @Bean
  public EmbeddedServletContainerCustomizer customizer() {
    return container -> {
      if (container instanceof TomcatEmbeddedServletContainerFactory) {
        TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
        tomcat.addContextCustomizers(context -> context.setCookieProcessor(new LegacyCookieProcessor()));
      }
    };
  }
}