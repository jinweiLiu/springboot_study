package demo.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Role {
    private String id;
    private String rolename;
    /**
     * 角色对应权限集合
     */
    //private Set<Permission> permissions;
}
