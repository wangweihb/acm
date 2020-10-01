package offer.jianzhi;

import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *（注意：这两个序列的长度是相等的）
 *
 * 这个题看了剑指offer思路指导依然没有写出来，代码实现不好写。但是这个程序却实现了相同的思路，很简洁！
 * */
public class 栈的压入弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        //如果输入的两个数组是空的话，返回false
        if (pushA==null&& popA==null){
            return false;
        }
        if (pushA==null || popA == null){
            return false;
        }
        //如果长度不相等，直接false
        if (pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackPoP = new Stack<>();
        for (int i= 0;i<popA.length;i++){
            stackPoP.push(popA[i]);
        }
        //根据pop的序列还原真实的push和pop序列
        int pop = stackPoP.pop();
        int pushstack;
        if (stack.empty()){
            for (int i = 0;i<pushA.length;i++){
                while (pop!=pushA[i]){
                    stack.push(pushA[i]);
                }
                pop = stackPoP.pop();
                pushstack = stack.pop();
                while (pop==pushstack){
                    pop = stackPoP.pop();
                    pushstack = stack.pop();
                }
                stack.push(pushstack);
            }
        }
        return false;
    }
}
