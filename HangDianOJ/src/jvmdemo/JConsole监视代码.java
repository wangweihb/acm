package jvmdemo;

import java.util.ArrayList;
import java.util.List;

/**深入理解jvm
 * 117页*/
class OOMObject{
    public byte[] placeholder = new byte[64 * 1024];
}
public class JConsole监视代码 {
    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for(int i = 0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }
    public static void main(String [] args) throws Exception{
        fillHeap(1000);
    }
}
