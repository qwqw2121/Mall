package com.util;
 
import java.math.BigDecimal;
 
public class BigDecimalUtil {
    //不能在外部实例化，放一个私有构造器
    private BigDecimalUtil(){
    }
    //加法
    public static BigDecimal add(double v1,double v2){
        BigDecimal b1=new BigDecimal(Double.toString(v1));//把double的v1转换成string
        BigDecimal b2=new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }
    //减法
    public static BigDecimal sub(double v1,double v2){
        BigDecimal b1=new BigDecimal(Double.toString(v1));//把double的v1转换成string
        BigDecimal b2=new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }
    //乘法
    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1=new BigDecimal(Double.toString(v1));//把double的v1转换成string
        BigDecimal b2=new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }
    //除法
    public static BigDecimal div(double v1,double v2){
        BigDecimal b1=new BigDecimal(Double.toString(v1));//把double的v1转换成string
        BigDecimal b2=new BigDecimal(Double.toString(v2));
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);//四舍五入，保留2位小数
    }
}
