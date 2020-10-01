package offer.jianzhi;

public class 整数n中1出现的次数 {

    public static void main(String [] args){

        System.out.println(101%10);
        System.out.println(112%10);
        System.out.println(117/10);
        System.out.println(1212%100);
//        java是下取整
        System.out.println(19/5);

        System.out.println("123".compareTo("321"));

    }

    public int obtainOneNum(int num){
        int count = 0;
        while (num > 0){
            if(num%10 == 1){
                count+=1;
            }
            num = num/10;
        }
        return count;
    }
}
