package demo.mapper;

import demo.entity.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PetMapper {
    @Select("select * from pet where pet.id = #{id}")
    Pet selectById(@Param("id") String id);

    @Select("select * from pet where pet.name = #{name}")
    Pet selectByName(@Param("name") String name);
}
