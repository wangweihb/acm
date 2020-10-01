package offer.jianzhi;

import java.util.Stack;
/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * */
public class 包含min函数的栈 {
    //这个stack是存数据的
    public static  Stack<Integer> stack1 = new Stack();
    //第二个stack是存辅助数组的，也就是最小值的
    public static Stack<Integer> stack2 = new Stack();
    public static void push(int node) {

        if (stack1.empty()){
            stack1.push(node);
            stack2.push(node);
        }else {
            stack1.push(node);
            //当目前入栈的值小于最小值，把最小值入栈，如果比最小值大，就把最小值再次入栈。
            int top = stack2.pop();
            stack2.push(top);
            if (top>node){
                stack2.push(node);
            }else {
                stack2.push(top);
            }
        }
    }

    public static void pop() {
        stack1.pop();
        stack2.pop();
    }

    //返回栈顶的元素
    public static int top() {
        int top = stack1.pop();
        stack1.push(top);
        return top;
    }

    public static int min() {
        int min = stack2.pop();
        stack2.push(min);
        return min;
    }

    public static void main(String [] args){
        push(2);
        push(5);
        push(3);
        push(7);
        push(1);
        pop();
        pop();
        pop();
        pop();


    }

}
