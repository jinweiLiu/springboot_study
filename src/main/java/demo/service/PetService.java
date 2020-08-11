package demo.service;

import demo.entity.Pet;
import demo.mapper.PetMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PetService {

    @Resource
    private PetMapper petMapper;

    public Pet getPet(){
        Pet pet = petMapper.selectByName("dog");
        log.info(pet.toString());
        return pet;
    }
}
