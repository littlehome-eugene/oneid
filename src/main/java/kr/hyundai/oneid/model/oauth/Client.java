package kr.hyundai.oneid.model.oauth;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

import java.io.Serializable;

@Data
public class Client implements Serializable {

	private String clientId;
	private String clientSecret;
	private Set<String> scope = Collections.emptySet();
  private Set<String> resourceIds = Collections.emptySet();
  private Set<String> authorizedGrantTypes = Collections.emptySet();

	private Set<String> registeredRedirectUris;
  private Set<String> autoApproveScopes;
	private List<GrantedAuthority> authorities = Collections.emptyList();
  private Integer accessTokenValiditySeconds;
  private Integer refreshTokenValiditySeconds;
  private Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();

}
