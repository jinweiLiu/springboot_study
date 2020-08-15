package demo.entity;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String roleid;
    /**
     * 用户对应的角色集合
     */
    //private Set<Role> roles;
}
