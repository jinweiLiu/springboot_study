package demo.entity;

import lombok.Data;

@Data
public class Pet {

    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
