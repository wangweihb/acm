package offer.jianzhi;

import java.util.Stack;
/**完美AC
 * 思路：第一个栈存放输入的数字，
 * pop()的时候，从第二个栈弹出数据，
 * 如果没有，吧第一个栈中的所有的数据转移到第二个栈中，再弹数据
 * 如果用两个栈实现队列怎么实现？！
 * */
class Niuke {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()){
            if (stack1.empty()){
                return Integer.parseInt(null);
            }else {
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}
public class 用两个栈实现队列 {
    public static void main(String [] args){
        Niuke niuke= new Niuke();
        //System.out.println(niuke.pop());
        //完美AC
        niuke.push(1);
        niuke.push(2);
        System.out.println(niuke.pop());
        niuke.push(3);
        niuke.push(4);
        System.out.println(niuke.pop());
        System.out.println(niuke.pop());
        System.out.println(niuke.pop());

    }
}
