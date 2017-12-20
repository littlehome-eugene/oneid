package kr.hyundai.oneid.model.oauth;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.util.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

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
  private String additionalInformation;

  // @JsonIgnoreProperties
  // private Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();


  public Client(BaseClientDetails clientDetails) {
    this.clientId = clientDetails.getClientId();
    this.clientSecret = clientDetails.getClientSecret();
    this.registeredRedirectUris = StringUtils
      .collectionToCommaDelimitedString(clientDetails.getRegisteredRedirectUri());
  }
}
