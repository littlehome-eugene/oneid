package kr.hyundai.oneid.controller;
import org.springframework.http.HttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;
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