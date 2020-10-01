package offer.leetcode;

import java.util.*;


/**
 * 头条的面试题。。。注意！！！！
 * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * l记录的是"("的数量， r记录的是")"的数量；并且只有在l > r的情况下才能增加")"括号；
 *
 */
public class _22括号生成 {

    static List<String> res = new ArrayList();
    //DFS遍历。。。。好好的想一下。、。。。
    public static  List<String> generateParenthesis(int n) {
        if (n <= 0){
            return res;
        }
        dfs(0, 0, n, "");
        return res;
    }

    public static void dfs(int l, int r, int n, String s){
        if(l == r && l == n){
            res.add(s);
        } else{
            if(l == r){
                dfs(l+1, r, n, s+"(");
            }else if(l > r){
                if(l < n){
                    dfs(l+1, r, n, s+"(");
                }
                dfs(l, r+1, n, s+")");
            }
        }
    }

    public static void main(String [] args){
       System.out.print( generateParenthesis(2));
    }

}
