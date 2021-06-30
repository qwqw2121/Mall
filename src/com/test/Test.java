package com.test;
import com.util.BigDecimalUtil;
import com.util.DateUtils;
import com.util.MD5Util;
import java.util.Date;
public class Test {
    public static void main(String[] args){
        double n1=0.05;
        double n2=0.01;
        System.out.println(BigDecimalUtil.add(n1,n2));
        String psw="123";
        String result= MD5Util.md5(psw);
        System.out.println(result);
        System.out.println(new Date());
        System.out.println(DateUtils.date2Str(new Date(),"yyyy.MM.dd HH:mm:ss"));
        System.out.println(DateUtils.date2Str(new Date()));
    }
}
