package com.meidp.butterknifedemo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wzh on 2016/9/6.
 */

/**
 * 只能输入数字："^[0-9]*$"。
 只能输入n位的数字："^\d{n}$"。
 只能输入至少n位的数字："^\d{n,}$"。
 只能输入m~n位的数字：。"^\d{m,n}$"
 只能输入零和非零开头的数字："^(0|[1-9][0-9]*)$"。
 只能输入正实数："^[0-9]+(.[0-9]*)?$"。
 只能输入有1~3位小数的正实数："^[0-9]+(.[0-9]{1,3})?$"。
 只能输入非零的正整数："^\+?[1-9][0-9]*$"。
 只能输入非零的负整数："^\-[1-9][]0-9"*$。
 只能输入长度为3的字符："^.{3}$"。
 只能输入由26个英文字母组成的字符串："^[A-Za-z]+$"。
 只能输入由26个大写英文字母组成的字符串："^[A-Z]+$"。
 只能输入由26个小写英文字母组成的字符串："^[a-z]+$"。
 只能输入由数字和26个英文字母组成的字符串："^[A-Za-z0-9]+$"。
 只能输入由数字、26个英文字母或者下划线组成的字符串："^\w+$"。
 验证用户密码："^[a-zA-Z]\w{5,17}$"正确格式为：以字母开头，长度在6~18之间，只能包含字符、数字和下划线。
 验证是否含有^%&',;=?$\"等字符："[^%&',;=?$\x22]+"。
 只能输入汉字："^[\u4e00-\u9fa5]{0,}$"
 验证Email地址："^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"。
 验证InternetURL："^http://%28[/\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$"。
 验证电话号码："^(\(\d{3,4}-)|\d{3.4}-)?\d{7,8}$"正确格式为："XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"。
 验证身份证号（15位或18位数字）："^\d{15}|\d{18}$"。
 验证一年的12个月："^(0?[1-9]|1[0-2])$"正确格式为："01"～"09"和"1"～"12"。
 验证一个月的31天："^((0?[1-9])|((1|2)[0-9])|30|31)$"正确格式为；"01"～"09"和"1"～"31"。
 */

public class ValidityUtils {
    private static final String NUMBER_PATTERN = "^[0-9]+(.[0-9]*)?$";// 判断小数点后一位的数字的正则表达式

    private static final String CNUMBER_PATTERN = "^\\+?[1-9][0-9]*$";// 判断数字的正则表达式

    /**
     * 验证是不是数字(验证到小数点后一位)
     *
     * @param number
     * @return
     */
    public static boolean isDouble(String number) {
        return match(NUMBER_PATTERN, number);
    }


    /**
     * 验证是不是数字(没有小数点)
     *
     * @param number
     * @return
     */
    public static boolean isInteger(String number) {
        return match(CNUMBER_PATTERN, number);
    }

    /**
     * 执行正则表达式
     *
     * @param pattern
     *            表达式
     * @param str
     *            待验证字符串
     * @return 返回 <b>true </b>,否则为 <b>false </b>
     */
    private static boolean match(String pattern, String str) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.find();
    }
}
