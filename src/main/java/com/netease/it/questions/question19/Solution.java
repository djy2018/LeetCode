package com.netease.it.questions.question19;

/**
 * @author dujiayong
 * @date 2019/04/08
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode ite = head;
        while (ite.next != null) {
            len++;
            ite = ite.next;
        }

        n = len - n + 1;

        if (n == 1) {
            ListNode next = head.next;
            return next;
        } else {
            ListNode pre = head;
            ListNode cur = head.next;
            while (n > 2 && cur.next != null) {
                pre = cur;
                cur = cur.next;
                n--;
            }

            if (cur.next == null) {
                pre.next = null;
            } else {
                // 断开连接，重新建立节点连接
                pre.next = cur.next;
                cur.next = null;
            }
        }
        return head;
    }
}
