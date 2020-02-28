package com.netease.it.questions.nowcoder.offer.question13;

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

    public static ListNode ReverseList(ListNode head) {
        // 边界退出条件
        if(head == null || head.next == null){
            return head;
        }

        // 思路分析:1->2->3->4->5 拆分成 1->2 => 2->1 然后针对剩下3->4->5进行递归
        // 接着递归执行的结果得到的结点 5->4->3 再拼接当前 2->1 => 5->4->3->2->1
        ListNode post = head.next;
        head.next = null;
        if(post.next == null){
            // 只有2个结点
            post.next = head;
            return post;
        }else{
            // 结点数大于2
            // 先翻转前2个结点，得到post结点
            ListNode next = post.next;
            post.next = head;
            // 递归翻转post.next结点
            ListNode node = ReverseList(next);
            // 拼接递归得到的结点和post结点
            ListNode last = node;
            while (last.next != null){
                last = last.next;
            }
            last.next = post;
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new Solution.ListNode(1);
        ListNode node2 = new Solution.ListNode(2);
        ListNode node3 = new Solution.ListNode(3);
        ListNode node4 = new Solution.ListNode(4);
        ListNode node5 = new Solution.ListNode(5);

        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        ListNode node = ReverseList(node1);
        System.out.println("end...");
    }

}
