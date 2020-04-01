package com.netease.it.questions.group2.question25;

/**
 * @author dujiayong
 * @date 2019/04/11
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        if (k == 1) {
            return reverseLinkedList(head);
        }

        int n = 1;
        ListNode newHead = new ListNode(head.val);
        ListNode newEnd = newHead;
        while (n < k && head.next != null) {
            head = head.next;
            ListNode next = new ListNode(head.val);
            newEnd.next = next;
            newEnd = newEnd.next;
            n++;
        }

        if (n < k) {
            return newHead;
        } else {
            ListNode headK = reverseLinkedList(newHead);
            ListNode endK = headK;
            while (endK.next != null) {
                endK = endK.next;
            }
            if (head.next != null) {
                endK.next = reverseKGroup(head.next, k);
            }
            return headK;
        }
    }

    /**
     * 递归翻转链表
     *
     * @param listNode
     * @return
     */
    public static ListNode reverseLinkedList(ListNode listNode) {
        if (listNode.next == null) {
            // 单节点
            return listNode;
        }
        ListNode newHead = reverseLinkedList(listNode.next);
        ListNode newEnd = newHead;
        while (newEnd.next != null){
            newEnd = newEnd.next;
        }
        newEnd.next = new ListNode(listNode.val);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = reverseKGroup(node1, 1);
        System.out.println("result==" + listNode);

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;
//
//        ListNode listNode = reverseLinkedList(node1);
//        System.out.println("-------end");


    }


}
