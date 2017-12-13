package kr.hyundai.oneid.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    String id;

    String password;

    String type = "USER";
}
