package com.example.leetcode.editor.cn;
//反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

class Solution_206 {

    public ListNode reverseList(ListNode head) {
        //双指针
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //1. 截取当前节点之后链表
            ListNode temp = cur.next;
            //2. 将当前节点给到 pre
            cur.next = pre;
            pre = cur;
            //3. 更新 cur
            cur = temp;
        }
        return pre;
    }
    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
