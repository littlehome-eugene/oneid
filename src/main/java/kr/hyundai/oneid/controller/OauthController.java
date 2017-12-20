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

  @Autowired
	OauthService service;

  @RequestMapping("/client/register")
  public String clientRegister() {
    return "client_register";
  }



}
