package demo.controller;

import demo.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ValidController {

    @RequestMapping("/addUser")
    public String showPage( Users users){
        return "valid";
    }

    /**
     * 完成用户添加
     *@Valid 开启对 Users 对象的数据校验
     *BindingResult:封装了校验的结果
     */
    @RequestMapping("/save")
    public String saveUser(@Valid Users users, BindingResult result){
        if(result.hasErrors()){
            return "valid";
        }
        System.out.println(users.toString());
        return "home";
    }
}
