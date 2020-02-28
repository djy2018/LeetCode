package com.netease.it.questions.nowcoder.offer.question14;

/**
 * Created by dujiayong on 2020/2/18.
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // 建立用来保存合并链表的结点
        ListNode merge = null;
        // 合并链表表头结点
        ListNode mergeHead = null;

        // 当链表1和链表2都不为null时遍历
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(merge == null){
                    merge = new ListNode(list1.val);
                    mergeHead = merge;
                }else{
                    ListNode node = new ListNode(list1.val);
                    merge.next = node;
                    merge = merge.next;
                }
                list1 = list1.next;
            }else{
                if(merge == null){
                    merge = new ListNode(list2.val);
                    mergeHead = merge;
                }else{
                    ListNode node = new ListNode(list2.val);
                    merge.next = node;
                    merge = merge.next;
                }
                list2 = list2.next;
            }
        }

        // 如果list1遍历结束,且list2尚未结束，此时合并链表直接追加list2;
        if(list1 == null){
            merge.next = list2;
        }
        // 同理,如果list2遍历结束，且list1尚未结束，此时合并链表直接追加list1;
        if(list2 == null){
            merge.next = list1;
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node3.next = node5;
        node1.next = node3;

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        ListNode node10 = new ListNode(10);
        node8.next = node10;
        node6.next = node8;
        node4.next = node6;
        node2.next = node4;

        ListNode merge = Merge(node1, node2);
        System.out.println("end...");
    }

}
