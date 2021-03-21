package com.xuganwen.utilmodule;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 文件描述:  时间工具类
 * 作者: 徐干稳
 * 创建日期: 2020/04/01 8:25
 * 版本 1.0
 */
public class TimeUtil {

    private static int second = 1000;
    private static long minute = 60 * second;
    private static long hour = 60 * minute;


    public static String Date_Format="yyyy-MM-dd";
    public static String Time_Format="HH:mm:ss";
    public static String Date_Format_With_Time_1="yyyy-MM-dd HH:mm:ss";
    public static String Date_Format_With_Time_2="yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static String Date_Format_With_Time_3="yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 获取当前时间毫秒数
     * */
    public static long getCurrentTimeMillis(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Instant instant=Instant.now();
            return  instant.toEpochMilli();
        }else {
            return System.currentTimeMillis();
        }
    }


    /**
     *
     * @param template 取值为上述声明的五个变量中的一个，这里没有用枚举来表示 主要是考虑到开放修改的原因，其实可以用枚举如：
     *                 enum FormatterDef{
     *                      Date_Format("yyyy-MM-dd")
     *                       private String value
     *                      public FormatterDef(String value){
     *                         this.value=value;
     *                      }
     *                      public String getValue(){
     *                         return this.value;
     *                      }
     *                 }
     * */
    public static String getFormattedString(Date date,String template){
        SimpleDateFormat formatter1=new SimpleDateFormat(template, Locale.CHINA);
        formatter1.setTimeZone(TimeZone.getTimeZone("GMT+8"));   //GMT是格林尼治标准时间   +8就是中国区时间
        return formatter1.format(date);
    }
}
