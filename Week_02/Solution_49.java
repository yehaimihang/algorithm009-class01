package com.example.leetcode.editor.cn;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

import com.example.common.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_49 {
    Map<String, List<String>> temp = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return  new ArrayList<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!temp.containsKey(keyStr)) temp.put(keyStr, new ArrayList<>());
            temp.get(keyStr).add(s);
        }
        return new ArrayList<>(temp.values());
    }
}