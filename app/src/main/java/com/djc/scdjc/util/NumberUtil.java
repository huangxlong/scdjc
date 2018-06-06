package com.djc.scdjc.util;

/**
 * Created by Administrator
 * on 2018/5/17 星期四.
 */
public class NumberUtil {

    public static String conversion(int num) {
        if (num < 10000) {
            return num + "";
        }
        String unit = "万";

        double newNum = num / 10000.0;
        String numStr = String.format("%." + 1 + "f", newNum);

        return numStr + unit;

    }
}
