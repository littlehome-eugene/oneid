package kr.hyundai.oneid.controller;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hyundai.oneid.model.oauth.Client;
import kr.hyundai.oneid.service.OauthService;


@RestController
public class OauthRestController {

  @Autowired
  OauthService service;

  @RequestMapping("/client/register")
  public String clientRegister(String redirectUri1) {

		BaseClientDetails clientDetails = new BaseClientDetails();
    String clientId = UUID.randomUUID().toString();
		clientDetails.setClientId(clientId);
    String clientSecret = UUID.randomUUID().toString();
		clientDetails.setClientSecret(clientSecret);

    List<String> scopes = Arrays.asList("read");
    clientDetails.setScope(Arrays.asList("read"));
    clientDetails.setAutoApproveScopes(scopes);

    List<String> grantTypes = Arrays.asList("authorization-code");
    clientDetails.setAuthorizedGrantTypes(grantTypes);

    Set<String> redirectUris = new HashSet<String>(Arrays.asList(redirectUri1));
    clientDetails.setRegisteredRedirectUri(redirectUris);

		service.addClientDetails(clientDetails);
    return clientDetails;
  }

}
