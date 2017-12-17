@Configuration
public class ThymeleafConfig {

@Bean
public ServletContextTemplateResolver templateResolver() {
    ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
    resolver.setPrefix("/WEB-INF/templates/");
    resolver.setSuffix(".html");
    resolver.setTemplateMode("LEGACYHTML5");
    resolver.setOrder(1);
    return resolver;
}
}
