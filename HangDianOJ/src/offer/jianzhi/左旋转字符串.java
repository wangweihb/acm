package offer.jianzhi;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 *
 *
 * */
public class 左旋转字符串 {
    public static  String LeftRotateString(String str,int n) {
        int strLen = str.length();
        int splitLen = 0;
        if (strLen == 0){
            return str;
        }
        if (n>strLen){
            splitLen = n%strLen;
        }else {
            splitLen = n;
        }
        String endStr = str.substring(0,splitLen);
        String preStr = str.substring(splitLen,str.length());
        return preStr+endStr;
    }

    public static void main(String [] args){
        String res = LeftRotateString("123456",9);
        System.out.println(res);
    }
}
