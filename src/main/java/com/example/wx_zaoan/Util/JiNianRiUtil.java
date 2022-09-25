package com.example.wx_zaoan.Util;

/**
 * @author YangChenxi
 */
import sun.util.calendar.BaseCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName JiNianRi
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 17:32
 */
public class JiNianRiUtil {
    /**
     * 恋爱
     */
    static String lianAi = "2021-04-09";

    /**
     * 生日
     */
    static String shengRi = "2000-12-26";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 距离date还有多少天
     * @param date
     * @return
     */
    public static int before(String date) {
        int day = 0;
        try {
            Date dateNow = new Date();
            int year = dateNow.getYear() + 1900;
            String today = year + "-" + (dateNow.getMonth()+1) + "-" + (dateNow.getDate());
            String target = year + "-" + "12-" + "26";
            Date start = simpleDateFormat.parse(today);
            Date end = simpleDateFormat.parse(target);
            long time = end.getTime() - start.getTime() ;
            day = (int) (time / (24*60*60*1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(day > 0){
            return  day;
        }else{
            return (-day);
        }

    }


    /**
     * 已经过去date多少天
     * @param date
     * @return
     */
    public static int after(String date) {
        int day = 0;
        try {
            long time = System.currentTimeMillis() - simpleDateFormat.parse(date).getTime();
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(day > 0){
            return day;
        }else{
            return -day;
        }

    }


    public static int getLianAi() throws ParseException {
        int day = 0;
        long time = simpleDateFormat.parse(lianAi).getTime() - System.currentTimeMillis();
        day = (int) (time / 86400000L);
        if(day > 0){
            return day;
        }else{
            return -day;
        }
    }

    public static int getShengRi(){
        return after(shengRi);
    }
    public static int guoShengRi(){
        return before(shengRi);
    }
    public static void main(String[] args) throws ParseException {
        System.out.println(getShengRi());
    }



}