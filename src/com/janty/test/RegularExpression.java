package com.janty.test;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Janty
 * @projectName: 正则表达式练习
 * @date: 2023/2/2 14:37
 * @description:
 */
public class RegularExpression {
    @Test
    void test(){
        Boolean flag = false;
        if (flag = false)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }

    }

    public static void main(String[] args) {
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        String content = "dagdf12_2-123asda@ga.asd.com";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
//        System.out.println(content.matches(regStr));
        if(matcher.find()){
            System.out.println(content+"格式匹配");
        }else {
            System.out.println(content+"格式不匹配");
        }

        String regStr2 = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        String content2 = "-101.23";
        if(content2.matches(regStr2)){
            System.out.println(content2+"格式匹配");
        }else {
            System.out.println(content2+"格式不匹配");
        }

                            //协议    域名          端口      文件名
        String regStr3 = "^(\\w{4,5})://([\\w\\.]+):(\\d+)/(\\w*/)*([a-zA-Z]+\\.[a-zA-Z]+)$";
        String content3 = "https://www.sohu.com:8080/abc/asd/sda/index.htm";
        Pattern compile = Pattern.compile(regStr3);
        Matcher matcher3 = compile.matcher(content3);
        while (matcher3.find()){
            System.out.println("完整网址："+matcher3.group(0));
            System.out.println("协议："+matcher3.group(1));
            System.out.println("域名："+matcher3.group(2));
            System.out.println("端口："+matcher3.group(3));
            System.out.println("文件名："+matcher3.group(5));
        }
    }
}
