  /**
You are given the head of a singly linked-list. The list can be represented as: 


 
L0 → L1 → … → Ln - 1 → Ln
 

 Reorder the list to be on the following form: 

 
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 

 You may not modify the values in the list's nodes. Only nodes themselves may 
be changed. 

 
 Example 1: 
 
 
Input: head = [1,2,3,4]
Output: [1,4,2,3]
 

 Example 2: 
 
 
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

 
 Constraints: 

 
 The number of nodes in the list is in the range [1, 5 * 10⁴]. 
 1 <= Node.val <= 1000 
 

 Related Topics 栈 递归 链表 双指针 👍 1123 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  public class ReorderList{
      public static void main(String[] args) {
          Solution solution = new ReorderList().new Solution();

      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    ListNode merge(ListNode node1,ListNode node2){
        ListNode head = new ListNode(),i = head;
        while(node1.next != null && node2.next != null){
            i.next = node1.next;
            i.next.next = node2.next;
            i = i.next.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        while(node1.next != null){
            i.next = node1;
            i = i.next;
        }
        while(node2.next != null){
            i.next = node2.next;
            i = i.next;
        }
        i = null;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        int n = 1;
        ListNode nodei = head;
        while(nodei.next != null){              //计算链表总长度
            n++;
            nodei = nodei.next;
        }

        nodei = head;
        for (int i = 0; i < n/2; i++) {
            nodei = nodei.next;                //一半位置处设置为node2的头结点
        }
        reverseList(nodei);
        head = merge(head,nodei);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }