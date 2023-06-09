package com.example.wx_zaoan.Job;

/**
 * @author YangChenxi
 */
import com.example.wx_zaoan.Util.PushUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 *@ClassName JobWorker
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 16:00
 */
@Component
public class JobWorker {
    //要推送的用户openid
    private static String openId = "oxqz15ijac1VBC1PqAX8OjIFXj34";

    @Scheduled(cron = "0 29 7 * * ?")
    public void goodMorning() throws ParseException {
        System.out.println("job works---");
        PushUtil.push(openId);
        PushUtil.push("oxqz15nzkP5RY6wwa8X2x7G5EJuE");
    }
}