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

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.UUID;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import kr.hyundai.oneid.model.oauth;

@Controller
public class OauthController {

    @RequestMapping("/client/register")
    public String clientRegister() {
        return "client_register";
    }


  @RequestMapping("/client/register", method=RequestMethod.POST)
  public String clientRegister(Client client) {

		db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
		jdbcTemplate = new JdbcTemplate(db);
		service = new JdbcClientDetailsService(db);

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


    List<String> redirectUris = client.getRedirectUris();
    clientDetails.setAuthorizedGrantTypes(redirectUris);

		service.addClientDetails(clientDetails);

    return "client_register";
  }


}
