package kr.hyundai.oneid.service;

import kr.hyundai.oneid.module.persistence.UserMapper;
import kr.hyundai.oneid.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User selectById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
