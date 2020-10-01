package offer.jianzhi;

import java.util.Stack;
//主要实现思路：一个栈和两指针模拟入栈出栈的操作
//step1:拿栈顶第一个元素是否等于popped当前指针popIndex的元素;
//---如果不相等，那就往栈push新元素 ，pushIndex指针后移一位
//---如果相等，popIndex+1,将栈顶的元素移除
//step2:重复step1
//结束条件：当popIndex 的值等于popedLength && pushIndex的值等于pushedLength的值，则返回true；否则返回false
public class 栈的压入弹出序列2 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        //pushIndex指针
        int pushI = 0;
        //popIndex指针
        int popI = 0;


        int pushLen = pushed.length;
        int popLen = popped.length;

        if(pushLen == popLen){
            while(popI < popLen && pushI <= pushLen){
                if(!stack.empty() && stack.peek() == popped[popI]){
                    popI+=1;
                    stack.pop();
                }else{
                    if(pushI == pushLen){
                        break;
                    }
                    stack.push(pushed[pushI]);
                    pushI+=1;
                }
            }
            if(popI == popLen && pushLen == pushI){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }


    public static void main(String [] args){
        boolean res = validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
        System.out.println(res);
    }
}
