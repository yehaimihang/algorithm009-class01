package com.example.leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

/**
 * 思路：
 * （1）一开始 i = j ,如果第一个值不为0, 不需要将值给到 j
 * （2）双指针，i 指针先走，走到不为0的位置，将这个位置值给到 j 指针，此时j 向前走一步,i 值变为0
 * 1. [0,1,0,3,12] ----> [0,1,0,3,12]   j=0
 * 2. [0,1,0,3,12] ----> [1,0,0,3,12]   j=1
 * 3. [1,0,0,3,12] ----> [1,0,0,3,12]   j=1
 * 4. [1,0,0,3,12] ----> [1,3,0,0,12]   j=2
 * 5. [1,0,0,3,12] ----> [1,3,12,0,0]   j=3 , i=4 end.
 */
class Solution_283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j)
                    nums[i] = 0;
                j++;
            }
        }
    }
}
