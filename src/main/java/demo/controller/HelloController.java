package demo.controller;

import demo.entity.Pet;
import demo.mapper.PetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@Slf4j 使用注解可以省略Logger logger = LoggerFactory.getLogger(HelloController.class)的创建代码
public class HelloController {

    /*@Autowired
    private PetMapper petMapper;*/

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Value("${url.orderUrl}")
    private String url;

    @RequestMapping("/hello")
    public String hello(){
        //Pet pet1 = petMapper.selectById("1");
        //Pet pet2 = petMapper.selectByName("cat");
        logger.info("===This project is running on"+url+"===");
        return "hello SpringBoot,this is my first Application" /*+ pet1.toString() + pet2.toString()*/;
    }
}
