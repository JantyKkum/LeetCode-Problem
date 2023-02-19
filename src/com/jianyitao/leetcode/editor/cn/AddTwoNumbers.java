  /**
You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a 
single digit. Add the two numbers and return the sum as a linked list. 

 You may assume the two numbers do not contain any leading zero, except the 
number 0 itself. 

 
 Example 1: 
 
 
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 

 Example 2: 

 
Input: l1 = [0], l2 = [0]
Output: [0]
 

 Example 3: 

 
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

 
 Constraints: 

 
 The number of nodes in each linked list is in the range [1, 100]. 
 0 <= Node.val <= 9 
 It is guaranteed that the list represents a number that does not have leading 
zeros. 
 

 Related Topics 递归 链表 数学 👍 9129 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;


  public class AddTwoNumbers{
      public static void main(String[] args) {
          Solution solution = new AddTwoNumbers().new Solution();


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){                                   //特殊情况
            return null;
        }
        if(l1.val == 0){
            return l2;
        }
        if(l2.val == 0){
            return l1;
        }

        ListNode ansHead = new ListNode(0);
        ListNode l3 = ansHead;                                              //头结点，不表示任何数
        int carry = 0;

        while(l1 != null && l2 != null){                          //l1.l2至少两位长
            l3.next = new ListNode((l1.val + l2.val + carry) % 10);     //末尾留余数
            carry = (l1.val + l2.val + carry) / 10;                         //进位
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }

        while (l1 != null){
            l3.next = new ListNode((l1.val + carry) % 10);     //末尾留余数
            carry = (l1.val + carry) / 10;                         //进位
            l1 = l1.next;
            l3 = l3.next;
        }
        while (l2 != null){
            l3.next = new ListNode((l2.val + carry) % 10);     //末尾留余数
            carry = (l2.val + carry) / 10;                         //进位
            l2 = l2.next;
            l3 = l3.next;
        }
        if(carry != 0){
            l3.next = new ListNode(carry);     //末尾留余数
        }
        return ansHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
  }