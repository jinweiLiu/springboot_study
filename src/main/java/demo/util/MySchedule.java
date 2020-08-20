package demo.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MySchedule {
    @Scheduled(fixedDelay = 1000) //当前任务执行结束1秒后开启另一个任务
    public void fixedDelay(){
        System.out.println("fixedDelay---" + new Date());
    }

    @Scheduled(fixedRate = 2000) //当前任务执行2秒后开启另一个任务
    public void fixedRate(){
        System.out.println("fixedRate---" + new Date());
    }

    @Scheduled(initialDelay = 1000, fixedRate = 2000) //首次执行的延迟时间
    public void initialDelay(){
        System.out.println("initialDelay---" + new Date());
    }

    @Scheduled(cron = "0/5 * * * * ?")  //每五秒执行一次
    public void cron(){
        System.out.println("cron---" + new Date());
    }
}
