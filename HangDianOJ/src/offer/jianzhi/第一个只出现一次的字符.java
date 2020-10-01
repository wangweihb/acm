package offer.jianzhi;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * 制作一个简单的hash表，字符的ASCLL码作为键，出现的次数作为值！将所有的东西保存下来！
 * UTF-8中，一个字符两个字节，也就是16位，c中一个字符8位。这个时候，可以问一下面试官，或者按照16位在计算，这儿按照8位来计算！
 * 
 * //注意以下几点：
 * 1、对输入为空进行验证
 * 2、jdk8和jdk7对str.split("")都不一样   jdk7   切开第一个是"",而8第一个就是我们字符串里面的首字母！！！
 * */
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
        String[] arr = str.split("");
        if ("".equals(str)){
            return -1;
        }
        //制作一个简易的hash表
        int [] resArr = new int[256];
        //循环，将arr入hash表
        for (int i = 0;i<arr.length;i++){
            int ascll = arr[i].charAt(0);
            resArr[ascll] = resArr[ascll]+1;
        }
        //循环遍历，找到第一个出现的元素
        for (int i = 0 ;i<arr.length;i++){
            if (resArr[arr[i].charAt(0)]==1){
                return i;
            }
        }
        return 0;
    }
    public static void main(String [] args){
        int index = FirstNotRepeatingChar("goole");
        System.out.println(index);
    }
}
