package cn.lishunxing.recursion;

import java.util.HashMap;

/**
 * 功能描述：斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * @link: https://leetcode.cn/problems/fibonacci-number/
 * @author: lishunxing
 * @date: 2024/9/5 15:08
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int result = fib(n - 1) + fib(n - 2);
        map.put(n, result);
        return result;
    }

}
