package PTA2021_5_30;

public class test {

}
class Solution {
    public boolean isNumber(String s) {
        //先处理特殊情况，由题意知不用处理
        //if(s==null||s.length()==0) return false;
        //把字符串以e或E为界限分成两部分
        int index = s.indexOf('e');
        if (index == -1) index = s.indexOf('E');
        //判断e或E之后是否为整数
        if (index != -1) {
            if (!isInteger(s.substring(index + 1)))
                return false;
            else {//再判断e或E之前的部分
                s = s.substring(0, index);
            }
        }
        //判断e或E之前的部分，index=-1时可认为e或E在最末尾，于是合并处理
        int dot = s.indexOf('.');
        if (dot == -1) {//没有小数点时直接判断是否为整数
            if (!isInteger(s))
                return false;
            else
                return true;
        } else {//有小数点时分别判断前后两部分
            String front = s.substring(0, dot);
            String tail = s.substring(dot + 1);
            //整数部分应为整数或者为空或者只有符号
            //整数部分为整数时
            if (isInteger(front)) {
                //小数部分可以为空
                if (tail.length() == 0)
                    return true;
                //小数部分可以为整数，但不能包括符号
                if (isInteger(tail) && Character.isDigit(tail.charAt(0)))
                    return true;
            }
            //整数部分为空或只有+、-时，小数部分不能为空
            if (front.length() == 0 || (front.length() == 1 && (front.charAt(0) == '+' || front.charAt(0) == '-'))) {
                //小数部分可以为整数，但不能包括符号
                if (isInteger(tail) && Character.isDigit(tail.charAt(0)))
                    return true;
            }
            return false;
        }
    }

    //整数可以包括正负号，其余部分应为数字
    public boolean isInteger(String s) {
        //确保非空
        if (s == null || s.length() == 0) return false;
        //先判断开头是不是正负号
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            //不能只有正负号
            if (s.length() == 1)
                return false;
            //取符号以外部分
            s = s.substring(1);
        }
        //符号位以外部分应为数字
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
