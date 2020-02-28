package com.netease.it.questions.nowcoder.offer.question3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dujiayong on 2020/2/5.
 */
public class Solution {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public static class ListNode{
        int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node3 = new Solution.ListNode(3);
        ListNode node2 = new Solution.ListNode(2);
        ListNode node1 = new Solution.ListNode(1);
        node2.next = node3;
        node1.next = node2;
        ArrayList<Integer> list = printListFromTailToHead(node1);
        System.out.println("list=" + list.toString());
    }

}
