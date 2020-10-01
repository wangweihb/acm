package offer.jianzhi;


/**
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 *  这个题 如果不使用split切割方法的话，可以反转的方式来做，首先反转所有的字符串，然后再使用前后指针翻转局部字符串！
 *
 * */
public class 翻转单词顺序列 {
    /**
    //方法一：使用split字符串方法切割来做！实现起来比较的容易
    //运行时间：21ms
    //占用内存：9560k
    public static  String ReverseSentence(String str) {
        if(str == null || str.trim().equals("")){
            return  str;
        }
        String [] strArr = str.split(" ");
        String res = "";
        for (int i = 0 ; i< strArr.length;i++){
            if (i == 0){
                res = res + strArr[strArr.length-1-i];
            }else
                res = res + " " +strArr[strArr.length-1-i];
        }
        return res;
    }
    */

    /**
     * 运行时间：25ms
     * 占用内存：9616k
     * 两个指针跑
     *
     * 自己写的还是有很大的问题！！！
     * */
    public static String ReverseSentence(String str) {
        if(str == null || str.trim().equals("")){
            return  str;
        }
        else {
            //首先进行全局反转
            str = reverseString(str, 0, str.length()-1);
            String res = "";
            int start = 0;
            int end = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    end = i-1;
                    if (res.trim().equals("")){
                        res = res + reverseString(str, start, end);
                    }else{
                        res = res + " " + reverseString(str, start, end);
                    }

                    start =i + 1;
                    end = i + 1;
                }
                if (i == str.length()-1){
                    end = i;
                    if (res.trim().equals("")){
                        res = res + reverseString(str, start, end);
                    }else{
                        res = res + " " + reverseString(str, start, end);
                    }
                    start =i + 1;
                    end = i + 1;
                }
                else
                    end = end + 1;
            }
            return res;
        }
    }
    //写一个反转字符串的方法,前闭后壁的区间
    public static String reverseString(String str,int start,int end){
        if (start == end){
            return String.valueOf(str.charAt(start));
        }
        String [] strArr = str.split("");
        String res = "";
//        for (int i = start;i<end;i++){
//            res = res + strArr[end-1];
//        }
        int k = end;
        while (k>=start){
            res = res + strArr[k];
            k = k - 1;
        }
        return res;
    }
    public static void main(String [] args){
        String str = "student. a am I";
        String res = ReverseSentence(str);
        System.out.println(res);
    }

}
