package demo.mapper;

import demo.entity.Permission;
import demo.entity.Role;
import demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByName(String username);
    Role getRole(String id);
    Permission getPermission(String roleid);
}
