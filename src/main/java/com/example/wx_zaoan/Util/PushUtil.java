package com.example.wx_zaoan.Util;

/**
 * @author YangChenxi
 */
import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.text.ParseException;
import java.util.Date;

/**
 *@ClassName Pusher
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 16:03
 */
public class PushUtil {
    /**
     * 测试号的appId和secret
     */
    private static String appId = "wxaa5137180d6c3363";
    private static String secret = "b239b57feff76c25680d8e3b188618d7";
    //模版id
    private static String templateId = "yWdBnlaVjNST0zj4PDiH-A1gjNVa3ikTm5xFnosBx9g";

    public static void push(String openId) throws ParseException {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                .url("http://124.221.208.250:1234/push")//点击模版消息要访问的网址
                //.url("http://127.0.0.1:1234/push")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        //填写变量信息，比如天气之类的
        JSONObject todayWeather = Tianqi.getTianqi();
        templateMessage.addData(new WxMpTemplateData("riqi",todayWeather.getString("date") + "  "+ todayWeather.getString("week"),"#FF69B4"));
        //templateMessage.addData(new WxMpTemplateData("riqi",new Date() + "","#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi",todayWeather.getString("text_day") + "  " + todayWeather.getString("text_night"),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low",todayWeather.getString("low") + "","#173177"));
        templateMessage.addData(new WxMpTemplateData("high",todayWeather.getString("high")+ "","#FF6347" ));
//        templateMessage.addData(new WxMpTemplateData("caihongpi",CaiHongPi.getCaiHongPi(),"#FF69B4"));
//        templateMessage.addData(new WxMpTemplateData("lianai",JiNianRi.getLianAi()+"","#FF1493"));
//        templateMessage.addData(new WxMpTemplateData("shengri",JiNianRi.getShengRi()+"","#FFA500"));
//        templateMessage.addData(new WxMpTemplateData("jinju",CaiHongPi.getJinJu()+"","#C71585"));
//        templateMessage.addData(new WxMpTemplateData("jiehun",JiNianRi.getJieHun()+""));
//        templateMessage.addData(new WxMpTemplateData("linzhen",JiNianRi.getLinZhen()+"","#FF6347"));
        String beizhu = "我今天也很爱你";
        String day  = todayWeather.getString("date");
        String yue = day.substring(5,7);
        String ri = day.substring(8,10);
        if(yue.equals("04") && ri.equals("09")){
            beizhu += "  今天是恋爱纪念日!!! ";
        }
        if(yue.equals("12") && ri.equals("26")){
            beizhu +="   今天是宝贝的生日！！！！！！";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu",beizhu,"#FF0000"));
        templateMessage.addData(new WxMpTemplateData("lianai",JiNianRiUtil.getLianAi() + "","#FF1493"));
        //templateMessage.addData(new WxMpTemplateData("shengri",JiNianRiUtil.getShengRi() + "","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("guoshengri",JiNianRiUtil.guoShengRi() + "","#FFA500"));
        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
