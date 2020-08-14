package demo.controller;

import demo.entity.Pet;
import demo.mapper.PetMapper;
import demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.awt.ModalExclude;

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
}
