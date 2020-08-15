package demo.service;

import demo.entity.Role;
import demo.entity.User;
import demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUserByName(String username){
        return userMapper.getUserByName(username);
    }

    public Set<String> getRoles(String username){
        Set<String> roles = new HashSet<>();
        String r = userMapper.getRole(userMapper.getUserByName(username).getId()).getRolename();
        roles.add(r);
        return roles;
    }

    public Set<String> getPermissions(String username){
        Set<String> permissions = new HashSet<>();
        User user = userMapper.getUserByName(username);
        Role role = userMapper.getRole(user.getId());
        String p = userMapper.getPermission(role.getId()).getPermissionname();
        permissions.add(p);
        return permissions;
    }
}
