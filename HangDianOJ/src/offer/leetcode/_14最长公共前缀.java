package offer.leetcode;

public class _14最长公共前缀 {

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;

        int pMin = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            pMin = Math.min(strs[i].length(), pMin);
        }


        int index = 0;
        String flag = "";
        String r = "";
        while(index < pMin){
            int count = 0;
            flag = "";
            for(int i = 0 ; i < len ;i++){
                String [] arr = strs[i].split("");
                if(i ==0) {
                    flag = arr[index];
                    count+=1;
                }else{
                    if(arr[index].equals(flag)){
                        count+=1;
                    }
                }
            }

            if(count != len){
                break;
            }
            r = r+flag;
            index+=1;
        }
        return r;
    }


    public static void main(String [] args){
        String res = longestCommonPrefix(new String[]{});
        System.out.println(res);
    }
}
