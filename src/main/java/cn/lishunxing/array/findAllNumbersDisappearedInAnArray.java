package cn.lishunxing.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述：找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果
 * @link: https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/
 * @author: lishunxing
 * @date: 2024/10/10
 */
public class findAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }


    /**
     * 思路：遍历数组，将每个元素对应的下标位置的值加上数组长度，然后遍历数组，如果某个元素对应的下标位置的值小于等于数组长度，则说明该元素没有出现过，将其加入结果列表中
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums) {
            // 这里因为前面可能给当前num已经加了length，所以这里要取模, 还原本来的数字大小
            int index = (num - 1) % length;
            nums[index] += length;
        }

        System.out.println(Arrays.toString(nums));
        // 遍历数组, 找出小于等于数组长度的元素，即为消失的数字
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length) {
                resultList.add(i + 1);
            }
        }
        return resultList;
    }
}
