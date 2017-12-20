package kr.hyundai.oneid.service;

import kr.hyundai.oneid.model.oauth.Client;
import kr.hyundai.oneid.model.user.User;
import kr.hyundai.oneid.module.persistence.OAuthMapper;
import kr.hyundai.oneid.module.persistence.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OauthService {

    @Autowired
    OAuthMapper oAuthMapper;

    public int insertClientValue(Client client) {
        return oAuthMapper.insertClientDetails(client);
    }
}
