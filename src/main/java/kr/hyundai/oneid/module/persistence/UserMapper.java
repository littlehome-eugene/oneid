package kr.hyundai.oneid.module.persistence;

import kr.hyundai.oneid.PayData;
import kr.hyundai.oneid.model.oauth.Client;
import kr.hyundai.oneid.model.user.User;

import java.util.List;

@PayData
public interface UserMapper {
    User selectByPrimaryKey(String id);

    void insertClients(List<Client> clientList);
}
