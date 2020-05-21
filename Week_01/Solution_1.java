package com.example.leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

import java.util.HashMap;

class Solution_1 {
    /**
     * 3.一遍哈希
     *   时间复杂度：O(n)
     *   空间复杂度：O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[] {hashMap.get(temp), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two nums solution.");
    }
    /**
     * 1.暴力求解
     *   时间复杂度：O(n^2)
     *   空间复杂度：O(1)
     *
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }*/
    /**
     * 2.两次哈希
     *   时间复杂度：O(n)
     *   空间复杂度：O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp) && i!=hashMap.get(temp)) {
                return new int[] {i, hashMap.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two nums solution.");
    }*/
}
