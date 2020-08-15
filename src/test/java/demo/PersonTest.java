package demo;

import demo.entity.Person;
import demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class PersonTest {
    @Autowired
    private Person person;

    @Resource
    private UserService userService;

    @Test
    public void test(){
        System.out.println(person.toString());
    }

    @Test
    public void testUserService(){
        System.out.println(userService.getUserByName("csdn1").toString());
    }

    @Test
    public void testGetRole(){
        System.out.println(userService.getPermissions("csdn1").toString());
    }
}
