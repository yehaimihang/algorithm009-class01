package com.example.leetcode.editor.cn;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针

/**
 * 思路：最大容积 = max( 两边距离 * 两柱最小高度 )
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution_11 {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            //贪心： 哪边边界大，另一边走一步
            res = height[l] < height[r] ?
                Math.max(res, (r-l) * height[l++]) :
                Math.max(res, (r-l) * height[r--]);
        }
        return res;
    }
}
