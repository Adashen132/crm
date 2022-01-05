package com.cyb.settings.test;

import com.cyb.crm.utils.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ccc
 * @create 2021-12-29 14:25
 */
public class Test1 {
    public static void main(String[] args) {
        //验证失效时间
        String expireTime = "2020-10-10 10:10:10";
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str = sdf.format(date);
//        System.out.println(str);
        //当前系统时间
        String currentTime = DateTimeUtil.getSysTime();

    }
}
