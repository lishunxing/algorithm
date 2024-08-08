package cn.lishunxing.stack;

import java.util.Stack;

/**
 * 功能描述：逆波兰表达式求值
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * @author: lishunxing
 * @date: 2024/8/8 15:48
 */
public class EvaluateReversePolishNotation {

    /**
     * 比如现有表达式 4,3,2,+,- 运算规则应该是 4-(3+2)
     * 首先压入栈中, 然后从栈中取出两个数进行运算, 运算结果再压入栈中, 直到栈中只有一个数, 返回栈顶元素
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        // 声明一个栈来存放操作数, 数字是从最后两个开始运算的
        Stack<Integer> stack = new Stack<>();
        for (String x : tokens) {
            // 加法可以不用判断先后顺序
            if ("+".equals(x)) {
                int result = stack.pop() + stack.pop();
                stack.push(result);
                continue;
            }

            // 减法的话就得是前一个数减去后面一个数字 这里就是 4 - 5
            if ("-".equals(x)) {
                int p = stack.pop();
                int a = stack.pop();
                int result = a - p;
                stack.push(result);
                continue;
            }

            // 乘法也不需要考虑先后
            if ("*".equals(x)) {
                int result = stack.pop() * stack.pop();
                stack.push(result);
                continue;
            }

            // 除法类似减法 需要考虑先后顺序
            if ("/".equals(x)) {
                int p = stack.pop();
                int a = stack.pop();
                int result = a / p;
                stack.push(result);
                continue;
            }

            stack.push(Integer.valueOf(x));
        }
        return stack.pop();
    }
}
