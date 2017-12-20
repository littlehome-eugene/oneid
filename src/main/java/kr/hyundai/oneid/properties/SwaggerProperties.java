package kr.hyundai.oneid.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;


@Component
@Data
@ConfigurationProperties(prefix = SwaggerProperties.PREFIX)
public class SwaggerProperties {
    public static final String PREFIX = "swagger";

    private String title = "Hyundai-Pay oneid API";

    private String description = "Hyundai-Pay API oneid documentation";

    private String version = "0.0.1";

    private String termsOfServiceUrl;

    private String contactName;

    private String contactUrl;

    private String contactEmail;

    private String license;

    private String licenseUrl;
}