package demo.controller;

import demo.entity.Pet;
import demo.entity.User;
import demo.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;

@Controller
public class ViewController {

    @Resource
    private PetService petService;

    @RequestMapping("/test404")
    public String test404() {
        return "index";
    }

    @RequestMapping("/test500")
    public String test500() {
        int i = 1 / 0;
        return "index";
    }

    @GetMapping("/object")
    public String testObject(Model model){
        Pet pet = petService.getPet();
        model.addAttribute("pet",pet);
        return "index";
    }

    @RequestMapping("/form")
    public String index(ModelMap map){
        User user = new User();
        user.setPassword("123456");
        user.setUsername("csdn1");

        map.put("user", user);
        return "login";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("user")User user){
        return "login";
    }
}
