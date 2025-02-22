package cn.lishunxing.array;

import java.util.Arrays;

/**
 * 功能描述：合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @link: https://leetcode.cn/problems/merge-sorted-array/
 * @author: lishunxing
 * @date: 2024/9/9 14:12
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new MergeSortedArray().merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 最简单粗暴的就是给nums2追加到nums1中, 然后对数组进行排序即可
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 这里我们把nums2的数据也合并到nums1中间, 因为nums1的后面n位都为0, 所以从最后一位开始存放
     * 分别从两个数组的最后一位数字开始比大小, 大的就往nums1最后存放
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            // 如果n小于0 说明此时nums2数组中元素都已经赋予到nums1中了, 直接返回nums1即可
            if (n < 0) {
                break;
            }
            // 如果m小于0 说明nums1中的元素都已经移动到了后方, 此时只需要继续给nums2中的元素填充到nums1的前i位即可
            if (m < 0) {
                nums1[i] = nums2[n];
                n--;
                continue;
            }
            // 比较nums1[m]位的元素与nums2[n]位的哪个大, 就往nums1的数组后面放. 同时给对应的m或者n下标往前移一位
            if (nums1[m] >= nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
        }
    }
}
