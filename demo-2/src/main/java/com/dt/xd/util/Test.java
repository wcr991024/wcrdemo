package com.xinda.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String date = "2019-11-23";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date testdate = null;
        try {
            testdate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(testdate.toString());
    }
}
