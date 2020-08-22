package demo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Users {
    @NotBlank //非空校验
    private String name;
    @NotBlank //密码非空校验
    private String password;
    @NotBlank
    private String age;
}
