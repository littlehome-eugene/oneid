package kr.hyundai.oneid.model.oauth;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client implements Serializable {

    private String clientId;
    private String clientSecret;
    private String scope;
    private String resourceIds;
    private String authorizedGrantTypes;

    private String registeredRedirectUris;
    private String autoApproveScopes;
    private String authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;

    @JsonIgnoreProperties
    private Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();
}
