package com.netease.it.questions.question21;

/**
 * @author dujiayong
 * @date 2019/04/09
 **/
public class Solution {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1 == null || l2 == null){
            // 输入条件: [] []
            return l1 != null ? l1 : l2;
        }
        if(l1.val > l2.val){
            head = new ListNode(l2.val);
            l2 = l2.next;
        }else{
            head = new ListNode(l1.val);
            l1 = l1.next;
        }

        ListNode end = head;

        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                ListNode node = new ListNode(l2.val);
                end.next = node;
                end = end.next;
                l2 = l2.next;
            }else{
                ListNode node = new ListNode(l1.val);
                end.next = node;
                end = end.next;
                l1 = l1.next;
            }
        }

        if(l1 != null){
            end.next = l1;
        }
        if(l2 != null){
            end.next = l2;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
