package cn.lishunxing.linked.list;

/**
 * 功能描述：节点
 * @author: lishunxing
 * @date: 2024/10/10
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
