package offer.jianzhi;

public class 把字符串换成整数 {
    public static int strToInt(String str) {

        boolean isStand = false;
        StringBuffer res = new StringBuffer();

        //将字符串转化为字符数组
        char [] arr = str.toCharArray();
        int len = arr.length;
        //剔除开头的是空格字符
        int i = 0;
        while(i <len && arr[i] == ' '){
            i+=1;
        }

        //判断开头是不是正负号或者数字
        if(i < len && (arr[i] == '+' || arr[i] == '-' || isNumber(arr[i]))){
            isStand = true;
            if(arr[i] == '+'){
                i++;
                res.append("+");
                while(i < len && isNumber(arr[i])){
                    res.append(arr[i]);
                    if(res.length() > 30 && Integer.valueOf(res.toString())>  Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
                return res.length() == 1 ? 0 :Integer.valueOf(res.toString());
            }
            if(arr[i] == '-'){
                i++;
                res.append("-");
                while(i < len && isNumber(arr[i])){
                    res.append(arr[i]);
                    if(res.length() > 30 && Integer.valueOf(res.toString()) < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }

                }
                return res.length() == 1 ? 0 :Integer.valueOf(res.toString());
            }else{
                while(i < len && isNumber(arr[i])){
                    res.append(arr[i]);
                    if(res.length() > 30 && Integer.valueOf(res.toString()) > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
                return Integer.valueOf(res.toString());

            }


        }else{
            return 0;
        }

        //

    }

    private static boolean isNumber(char k){
        if(k >= '0' && k <= '9'){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String [] args){
//        System.out.println(strToInt("42"));
        System.out.println(-91283472332l < Integer.MIN_VALUE);
    }
}
