package kr.hyundai.oneid.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    String userId;

    String password;

    String type = "USER";
}
