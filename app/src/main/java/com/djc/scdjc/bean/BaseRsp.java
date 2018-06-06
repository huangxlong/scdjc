package com.djc.scdjc.bean;

/**
 * Created by Administrator
 * on 2018/4/4 星期三.
 */
public class BaseRsp<T> {

    public static final int SUCCESS = 0;
    public static final int NO_ROOT = 1; //没有权限，未购买
    /**
     * 0：成功，1：失败
     */
    public int status;

    public String message;

    public T data;


    public static class News {
        public String title = "12131aeae";
        public String url = "213133";

        public String des = "1331dah合法化等等";
        public String time = "2018-02-01 14:12:12";
        public String zan = "31231";
        public String read = "23311";
    }

}
