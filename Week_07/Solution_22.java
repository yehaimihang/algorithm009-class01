package com.example.leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

class Solution_22 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return result;
        _generate(0, 0, n, "");
        return result;
    }

    private void _generate(int left, int right, int n, String str) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < n) _generate(left+1, right, n, str+"(");
        if (right < left) _generate(left, right+1, n, str+")");
    }
}
