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


@RestController
public class MainController {
    @RequestMapping("/user")
    public Principal user(Principal principal) {

        return principal;
    }

    @RequestMapping("/user2")
    public Map user2() {
      final String uri = "http://zibann.kr:10022/fakeUser";

      RestTemplate restTemplate = new RestTemplate();
      Map result = restTemplate.getForObject(uri, Map.class);

      // String result = restTemplate.getForObject(uri, String.class);

      // System.out.println(result);
      return result;
      // return principal;

    }

    @RequestMapping("/user3")
    public String user3() {
      final String uri = "http://zibann.kr:10022/fakeUser";

      RestTemplate restTemplate = new RestTemplate();
      // Map result = restTemplate.getForObject(uri, Map.class);

      String result = restTemplate.getForObject(uri, String.class);

      System.out.println(result);
      return result;
      // return principal;

    }


    @RequestMapping("/unauthenticated")
    public String unauthenticated() {
        System.out.printf("");
        return "redirect:/?error=true";
    }

    @RequestMapping("/oauth/authorize")
    public String authorize() {
        System.out.printf("");
        return "u";
    }

    @RequestMapping("/auth")
    public String auth() {
        System.out.printf("");
        return "u";
    }

    @RequestMapping(value = "/login/oauth_login", method = RequestMethod.GET)
    public String oauth_login(Principal principal) {
        if ((principal instanceof Authentication) && ((Authentication) principal).isAuthenticated()) {
            return "logged-in";
        } else {
            return "logged-out";
        }

    }


}
