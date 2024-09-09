package cn.lishunxing.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 功能描述：两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 * @link: https://leetcode.cn/problems/two-sum/
 * @author: lishunxing
 * @date: 2024/9/5 15:35
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }

    /**
     * 暴力枚举, 此方法的时间复杂度是O(n^2)
     */
    public static int[] twoSum(int[] nums, int target) {
        // 遍历数组, 循环数组长度-1次. 在这个数组 {2,7,11,15} 中, 最多会拿2,7,11 依次与后面的数字相加
        for (int i = 0; i < nums.length - 1; i++) {
            // 从下标i+1开始遍历, 第一次就是拿7,11,15 与2相加, 当i为2时, 就是拿11,15 与7 相加
            for (int j = i + 1; j < nums.length; j++) {
                // 如果有相加等于target的 就直接返回下标
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 这里我们可以考虑给所有使用过的元素都存起来, 到hashmap中, 把值作为hashMap的key, 下标作为value .
     * 这样我们遍历到后面的元素的时候, 只需要判断target - 当前元素值是否为hashMap中的key, 就可以直接找到2个元素的下标, 返回即可
     */
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
