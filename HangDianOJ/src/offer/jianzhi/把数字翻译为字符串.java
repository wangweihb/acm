package offer.jianzhi;

public class 把数字翻译为字符串 {
    /**
     * 画几种情况理解 为啥是F(i) = F(i-1) + F(i-2) {i > 0 && x >= 10 && x <= 25}
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        int p = 0 ;
        int q = 1;
        int c = 1;
        String src = String.valueOf(num);
        String [] nums = src.split("");
        for(int i = 0 ; i < nums.length ;i++){
            if(i == 0){
                c = 1;
            }else{
                if((nums[i-1]+nums[i]).compareTo("25") <= 0 && (nums[i-1]+nums[i]).compareTo("10") >= 0){
                    c = p+q;
                }else{
                    c = q;
                }
            }
            p = q;
            q = c;
        }
        return c;
    }

    /**
     * 递归方案
     * @param num
     * @return
     */
    static int count = 0 ;
    public static void translateNum2(int num) {
        myT(num);
    }

    public static void myT(int num){
        if(num > 0){
            myT(num/10);
            if(num%100 >= 10 && num%100<=25 ) {
                myT(num / 100);
            }
        }else {
            count++;
        }
    }


    public static void main(String [] args){
        System.out.println(translateNum(12123123));
        translateNum2(12123123);
        System.out.println(count);
    }

}
