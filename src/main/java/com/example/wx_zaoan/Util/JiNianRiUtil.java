package com.example.wx_zaoan.Util;

/**
 * @author YangChenxi
 */
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
            int year = dateNow.getYear();
            System.out.println(year);
            long time = simpleDateFormat.parse(date).getTime() - System.currentTimeMillis() ;
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(day > 0){
            return 365 - (day % 365);
        }else{
            return 365 - ((-day) % 365);
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


    public static int getLianAi() {
        System.out.println(before(lianAi));
        return before(lianAi);
    }

    public static int getShengRi(){
        return after(shengRi);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(before(shengRi));
    }



}