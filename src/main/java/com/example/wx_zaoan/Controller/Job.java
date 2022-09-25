package com.example.wx_zaoan.Controller;

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
public class Job {
    //要推送的用户openid
    private static String openId = "oxqz15nzkP5RY6wwa8X2x7G5EJuE";

    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorning() throws ParseException {
        PushUtil.push(openId);
    }

}