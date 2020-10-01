import java.text.DecimalFormat;
import java.util.Scanner;

public class 计算两点间的距离 {
    public static void main(String [] args){
        Scanner sr=new Scanner(System.in);
        double x1=0,y1=0,x2=0,y2=0,z;
        DecimalFormat df=new DecimalFormat("0.00");
        String d;
        while(sr.hasNext()){
            x1=sr.nextInt();
            y1=sr.nextInt();
            x2=sr.nextInt();
            y2=sr.nextInt();
            z=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
            d=df.format(Math.sqrt(z));
            System.out.println(d);
        }
    }
}
