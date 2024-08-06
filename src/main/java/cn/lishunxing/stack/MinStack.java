package cn.lishunxing.stack;

import java.util.Stack;

/**
 * 功能描述：最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * @link: https://leetcode.cn/problems/min-stack/description/
 * @author: lishunxing
 * @date: 2024/8/5 11:17
 */
public class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    /**
     * 初始化一个正常存放数据的栈, 还有一个用于存放最小值的栈
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 添加元素, 如果当前栈为空或者当前元素小于等于栈顶元素, 则将当前元素放入最小值栈
     */
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * 删除元素, 如果当前栈顶元素等于最小值栈顶元素, 则将最小值栈顶元素也删除
     */
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
