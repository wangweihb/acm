package offer.jianzhi;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//题解：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
//
public class 最长不含重复字符的子字符串 {
    int max= 0;
    public static void main(String [] args){
//        List<Char> list = new ArrayList();
//        list.add('1');
//        list.contains()
        System.out.println(lengthOfLongestSubstring("1a1b1c1d1"));
        System.out.println(lengthOfLongestSubstring1("1a1b1c1d1"));

        System.out.println(17/10);
    }

    //方法一：递归，超时了
     public void obtainMaxLength(ArrayList<String> list, String str){
         if(str.length() >0){
             String s = str.substring(0,1);
             if(!list.contains(s)){
                 list.add(s);
                 max = Math.max(list.size(),max);
                 obtainMaxLength(list, str.substring(1,str.length()));
             }
             obtainMaxLength(new ArrayList<String>(), str.substring(1,str.length()));
         }
     }


     //方法二：dp，简洁的写法
    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    //方法三：dp麻烦的写法
    public static int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int [] dp = new int[s.length()];
        int max = 0;
        for(int j = 0 ; j < s.length();j++){
            String str = s.substring(j,j+1);
            if(map.containsKey(str)){
                int i = map.get(str);
                map.put(str,j);
                if(j-i > dp[j-1]){
                    dp[j] = dp[j-1]+1;
                    max = Math.max(dp[j],max);
                }else{
                    dp[j] = j-i;
                    max = Math.max(dp[j],max);
                }
            }else{
                map.put(str, j);
                dp[j] = (j == 0 ? 1 : dp[j-1]+1);
                max = Math.max(dp[j],max);
            }
        }
        return max;
    }
}
