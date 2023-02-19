  /**
Given the head of a linked list, rotate the list to the right by k places. 

 
 Example 1: 
 
 
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
 

 Example 2: 
 
 
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

 
 Constraints: 

 
 The number of nodes in the list is in the range [0, 500]. 
 -100 <= Node.val <= 100 
 0 <= k <= 2 * 10⁹ 
 

 Related Topics 链表 双指针 👍 881 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;


  public class RotateList{
      public static void main(String[] args) {
          Solution solution = new RotateList().new Solution();
           
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
class Solution {
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode pre = null;       //前一指针
        ListNode p = head;         //当前指针
        while (p != null){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;                      //表示链表长度
        while (head != null){           //计算链表长度
            n++;
            head = head.next;
        }
        if(k >= n){                     //当k超过链表长度时，对n取模
            k = k % n;
        }
        ListNode l1 = head;             //子链表l1
        ListNode l2 = head;             //子链表l2
        for (int i = 0; i < n-k-1; i++) {
            head = head.next;
            l1 = head;
            l2 = head;
        }
        l1.next = null;                 //断开两个子链
        l2 = l2.next;                   //l2为头结点

        l1 = reverse(l1);               //逆置
        l2 = reverse(l2);
        ListNode ans = l1;              //记录合并链表的头结点

        for (int i = 0; i < n-k-1; i++) {
            l1 = l1.next;
        }
        l1.next = l2;
        return reverse(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
  }