package com.example.wx_zaoan.Controller;

/**
 * @author YangChenxi
 */
import com.example.wx_zaoan.Util.PushUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
public class PushController {
    //要推送的用户openid
    private static String ycx = "oxqz15nzkP5RY6wwa8X2x7G5EJuE";
    private static String wwy = "oxqz15ijac1VBC1PqAX8OjIFXj34";


    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/push")
    public void push() throws ParseException {
        PushUtil.push(ycx);
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/wwy")
    public void pushZyd() throws ParseException {
        PushUtil.push(wwy);
    }


    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/{id}")
    public void pushId(@PathVariable("id") String id) throws ParseException {
        PushUtil.push(id);
    }
}