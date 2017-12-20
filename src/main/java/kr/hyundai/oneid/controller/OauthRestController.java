package kr.hyundai.oneid.controller;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hyundai.oneid.model.oauth.Client;


@RestController
public class OauthRestController {

  @RequestMapping("/client/register", method=RequestMethod.POST)
  public String clientRegister(Client client) {

		BaseClientDetails clientDetails = new BaseClientDetails();
    String clientId = UUID.randomUUID().toString();
		clientDetails.setClientId(clientId);
    String clientSecret = UUID.randomUUID().toString();
		clientDetails.setClientSecret(clientSecret);

    clientDetails.setScope("read");
    List<String> scopes = Arrays.asList("read");
    clientDetails.setAutoApproveScopes(scopes);

    List<String> grantTypes = Arrays.asList("authorization-code");
    clientDetails.setAuthorizedGrantTypes(grantTypes);

    String redirectUri = client.getRedirectUri1();
    List<string> redirectUris = Arrays.asList(redirectUri);
    clientDetails.setRedirectUris(redirectUris);

		service.addClientDetails(clientDetails);
    return clientDetails;
  }

}