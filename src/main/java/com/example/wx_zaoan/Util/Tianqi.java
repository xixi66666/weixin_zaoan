package com.example.wx_zaoan.Util;

/**
 * @program: xw_zaoan
 * @description: 天气组件
 * @author: 杨晨曦
 * @create: 2023-06-10 00:14
 **/
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName Tianqi
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 16:45
 */
public class Tianqi {
    private static String ak = "c8Nq4GDQQ1eExgnPnuEzlpn8jUzNt2iW";
    private static String district_id = "532502";

    public static JSONObject getTianqi() {
        String result = null;
        JSONObject today = new JSONObject();
        try {
            result = HttpUtil.getUrl("https://api.map.baidu.com/weather/v1/?district_id=" + district_id + "&data_type=all&ak=" + ak);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.getString("message").equals("success")) {
                JSONArray arr = jsonObject.getJSONObject("result").getJSONArray("forecasts");
                today = arr.getJSONObject(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }

    public static void main(String[] args) {
        System.out.println(getTianqi());
    }
}
