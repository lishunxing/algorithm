package cn.lishunxing.stack;

import java.util.Stack;

/**
 * 功能描述：有效的括号
 * @link: https://leetcode.cn/problems/valid-parentheses/description
 * @author: lishunxing
 * @date: 2024/7/31 10:46
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     */
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    /**
     * 思路：此方法主要是使用栈来存储左括号，当遇到右括号时，判断栈顶元素是否与右括号匹配，如果匹配则出栈，否则返回false。
     */
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
