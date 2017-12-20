package kr.hyundai.oneid.module.persistence;

import kr.hyundai.oneid.PayData;
import kr.hyundai.oneid.model.oauth.Client;
import kr.hyundai.oneid.model.user.User;

import java.util.List;

@PayData
public interface OAuthMapper {
    Client selectByPrimaryKey(String id);

    int insertClientDetails(List<Client> client);
}
