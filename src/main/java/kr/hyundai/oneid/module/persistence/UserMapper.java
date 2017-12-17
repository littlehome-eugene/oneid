package kr.hyundai.oneid.module.persistence;

import kr.hyundai.oneid.PayData;
import kr.hyundai.oneid.user.User;

@PayData
public interface UserMapper {
    User selectByPrimaryKey(String id);
}
