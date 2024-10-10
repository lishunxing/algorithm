package cn.lishunxing.linked.list;

/**
 * 功能描述：合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @link: <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">合并两个有序链表</a>
 * @author: lishunxing
 * @date: 2024/10/10
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists(list1, list2);
        // 输出listNode所有值
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 思路： 创建一个头节点，然后比较两个链表节点的值，将较小的节点加入到新链表中，直到两个链表都为空
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个头结点, 用于返回合并好的链表结果
        ListNode head = new ListNode();
        // 创建一个临时节点，用于记录当前存放较小的链表节点
        ListNode temp = head;

        // 如果两个链表都不为空的情况下 进行遍历
        while (list1 != null && list2 != null) {
            // 如果list1的值小于list2的值，则将list1的值加入到新链表中，并将list1指向下一个节点
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            }
            // 否则，将list2的值加入到新链表中，并将list2指向下一个节点
            else {
                temp.next = list2;
                list2 = list2.next;
            }
            // 将temp指向下一个节点
            temp = temp.next;

        }
        // 如果两个链表有一个为空的情况下，则将另一个链表的剩余节点直接加入到新链表中
        if (list1 == null) {
            temp.next = list2;
        }

        if (list2 == null) {
            temp.next = list1;
        }

        // 返回新链表的头结点
        return head.next;
    }
}
