package cn.lishunxing.array;

/**
 * 功能描述：特殊数组2
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * 周洋哥有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，请你帮助周洋哥检查子数组 nums[fromi..toi] 是不是一个 特殊数组 。
 * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
 * @link https://leetcode.cn/problems/special-array-ii/
 * @author: lishunxing
 * @date: 2024/8/14 10:54
 */
public class SpecialArrayII {

    public static void main(String[] args) {
        int[] nums = {3,6,2,1};
        int [][] queries = {{0, 1}};
        boolean[] result = isArraySpecial(nums, queries);
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = true;
            int[] query = queries[i];
            int from = query[0];
            int to = query[1];
            if (from == to) {
                continue;
            }
            for (int j = from + 1; j <= to; j+=2) {
                int a = nums[j - 1];
                int b = j + 1 > to ? nums[j] + 1 : nums[j + 1];
                if (nums[j] % 2 == a % 2 || nums[j] % 2 == b % 2) {
                    result[i] = false;
                    break;
                }
            }
        }
        return result;
    }
}
