package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/test1/get/{id}")
    public String getUrl1(@PathVariable Integer id){
        return "success" + id;
    }

    @GetMapping("/test2/get/{idd}")
    public String getUrl2(@PathVariable(value = "id") Integer id){
        return "success" + id;
    }
}
