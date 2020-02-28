package com.netease.it.questions.nowcoder.offer.question12;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * Created by dujiayong on 2020/2/14.
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        // 定义长度为K链表的首尾结点
        ListNode pre = head, post = head;
        // 边界条件:列表为空/链表倒数k=0，此时都是返回结果都为Null;
        if (head == null || k == 0) {
            return null;
        }
        // 尾结点post后移k-1次，移动过程中若post.next=null，则head链表所给长度小于k，因此直接返回null
        for (int i = 0; i < k - 1; i++) {
            if (post.next != null) {
                post = post.next;
            } else {
                return null;
            }
        }
        // 构造的长度为k链表往后移动，直至尾端节点post.next=null退出，
        // 此时构造的链表pre就是head倒数k结点
        while (post.next != null) {
            pre = pre.next;
            post = post.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new Solution.ListNode(1);
        ListNode node2 = new Solution.ListNode(2);
        ListNode node3 = new Solution.ListNode(3);

        node2.next = node3;
        node1.next = node2;

        ListNode listNode = FindKthToTail(node1, 4);
        System.out.println("end...");
    }

}
