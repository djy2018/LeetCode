package com.netease.it.questions.leetcode.group2.question23;

/**
 * @author dujiayong
 * @date 2019/04/10
 **/
public class Solution {


    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int low = 0;
        int high = lists.length - 1;
        ListNode[] listNodes = new ListNode[(lists.length + 1) / 2];
        for (int i = 0; i < listNodes.length; i++) {
            if (low < high) {
                listNodes[i] = mergeTwoLists(lists[low], lists[high]);
            }
            if (low == high) {
                listNodes[i] = lists[low];
            }
            low++;
            high--;
        }
        if (lists.length == 1) {
            return lists[0];
        } else {
            return mergeKLists(listNodes);
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (l1 == null || l2 == null) {
            // 输入条件: [] []
            return l1 != null ? l1 : l2;
        }
        if (l1.val > l2.val) {
            head = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            head = new ListNode(l1.val);
            l1 = l1.next;
        }

        ListNode end = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode node = new ListNode(l2.val);
                end.next = node;
                end = end.next;
                l2 = l2.next;
            } else {
                ListNode node = new ListNode(l1.val);
                end.next = node;
                end = end.next;
                l1 = l1.next;
            }
        }

        if (l1 != null) {
            end.next = l1;
        }
        if (l2 != null) {
            end.next = l2;
        }
        return head;
    }

}
