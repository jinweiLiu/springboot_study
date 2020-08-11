package demo;

import demo.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonTest {
    @Autowired
    private Person person;

    @Test
    public void test(){
        System.out.println(person.toString());
    }
}
