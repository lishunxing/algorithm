package cn.lishunxing.stack;

import java.util.Stack;

/**
 * 功能描述：用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * @link https://leetcode.cn/problems/implement-queue-using-stacks/
 * @author: lishunxing
 * @date: 2024/8/6 15:14
 */
public class ImplementQueueUsingStacks {

    private Stack<Integer> inputStack;

    private Stack<Integer> outputStack;

    /**
     * 定义两个栈, 输入栈和输出栈
     */
    public ImplementQueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * 数据写入全部放入输入栈
     */
    public void push(int x) {
        inputStack.push(x);
    }

    /**
     * 输出栈为空时, 输入栈全部放入输出栈
     * 输出栈不为空时, 直接从输出栈弹出
     */
    public int pop() {
        if(!outputStack.isEmpty()){
            return outputStack.pop();
        }

        while(!inputStack.isEmpty()){
            outputStack.push(inputStack.pop());
        }

        if(!outputStack.isEmpty()){
            return outputStack.pop();
        }
        return 0;
    }

    /**
     * 输出栈为空时, 输入栈全部放入输出栈
     * 输出栈不为空时, 直接从输出栈弹出
     */
    public int peek() {
        if(!outputStack.isEmpty()){
            return outputStack.peek();
        }

        while(!inputStack.isEmpty()){
            outputStack.push(inputStack.pop());
        }

        if(!outputStack.isEmpty()){
            return outputStack.peek();
        }
        return 0;
    }

    /**
     * 判断输入栈和输出栈是否都为空
     */
    public boolean empty() {
        return outputStack.isEmpty() && inputStack.isEmpty();
    }
}
