package com.example.wx_zaoan;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.wx_zaoan.Util.HttpUtil;
import com.example.wx_zaoan.Util.Tianqi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class WxZaoanApplicationTests {
    private static String ak = "c8Nq4GDQQ1eExgnPnuEzlpn8jUzNt2iW";
    private static String district_id = "532502";

    @Test
    void contextLoads() {
    }


    @Test
    public void baiduTest() throws IOException {
        JSONObject todayWeather = Tianqi.getTianqi();
        String day  = todayWeather.getString("date");
        String jinian = day.substring(5,7);
        System.out.println(jinian);
        String jinian1 = day.substring(8,10);
        System.out.println(jinian1);
    }

}
