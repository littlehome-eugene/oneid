package kr.hyundai.oneid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.hyundai.oneid.service.OauthService;

@Controller
public class OauthController {

  @Autowired
	OauthService service;

  @RequestMapping("/client/register")
  public String clientRegister() {
    return "client_register";
  }



}
