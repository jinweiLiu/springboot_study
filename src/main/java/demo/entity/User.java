package demo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class User {

    private String id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String roleid;
    /**
     * 用户对应的角色集合
     */
    //private Set<Role> roles;
}
