package offer.leetcode;

import java.util.*;

public class _17电话号码的字母组合 {

    static List<String> res = new ArrayList<>();;
    public static List<String> letterCombinations(String digits) {
        Character [][] arr = new Character[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','f','h'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        String [] digitsArr = digits.split("");
        int a = digitsArr.length;
        deep(digitsArr, 0, arr, "");
        return res;

    }

    public static void deep(String[] digitsArr, int index , Character [][] arr, String s){
        if(index == digitsArr.length){
            res.add(s);
        }else{
            int num = Integer.valueOf(digitsArr[index]);
            Character [] crr = arr[num];
            for(int i  = 0 ; i < crr.length; i++){
                deep(digitsArr, index+1, arr, s + String.valueOf(crr[i]));
            }
        }

    }


    public static void main(String [] args){
        List<String> res  = letterCombinations("");
        System.out.println(res);
    }


}
