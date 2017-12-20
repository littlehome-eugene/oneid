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
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OAuthMapper oAuthMapper;

    public User selectById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public int insertClientValue(List<Client> clientList) {
        return oAuthMapper.insertClientDetails(clientList);
    }
}
