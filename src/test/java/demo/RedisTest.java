package demo;

import com.alibaba.fastjson.JSON;
import demo.entity.ExceptionRes;
import demo.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void redisString(){
        //测试redis的string类型
        redisService.setString("test","this is a test");
        log.info(redisService.getString("test").toString());

        // 如果是个实体，我们可以使用json工具转成json字符串，
        ExceptionRes exceptionRes = new ExceptionRes();
        redisService.setString("exception", JSON.toJSONString(exceptionRes));
        log.info("异常信息：{}", redisService.getString("exception"));
    }
}
