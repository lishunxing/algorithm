package cn.lishunxing.recursion;

import java.util.HashMap;

/**
 * 功能描述：爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @link: https://leetcode.cn/problems/climbing-stairs/
 * @author: lishunxing
 * @date: 2024/9/5 10:57
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
        System.out.println(climbStairs2(4));
    }

    /**
     * 普通递归方法
     */
    public static int climbStairs(int n) {
        // 如果只剩1层, 那就只有1种方法
        if (n == 1) {
            return 1;
        }
        // 如果剩2层, 那就有2种方法爬完, 一种爬两次1层, 一种直接爬两层
        if (n == 2) {
            return 2;
        }
        // 剩下的就递归接着爬, 爬完1层, 再爬剩下的, 然后与爬完2层的方法相加
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 优化递归方法 记录已经计算过的结果, 不用重复计算
     */
    private static HashMap<Integer,Integer> recordMap = new HashMap<>();
    public static int climbStairs2(int n) {
        // 判断是否已经计算过, 如果有就直接返回
        if (recordMap.containsKey(n)) {
            return recordMap.get(n);
        }

        // 如果只剩1层, 那就只有1种方法
        if (n == 1) {
            return 1;
        }
        // 如果剩2层, 那就有2种方法爬完, 一种爬两次1层, 一种直接爬两层
        if (n == 2) {
            return 2;
        }
        // 剩下的就递归接着爬, 爬完1层, 再爬剩下的, 然后与爬完2层的方法相加, 这里顺便写入记录
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        recordMap.put(n, result);
        return result;
    }
}
