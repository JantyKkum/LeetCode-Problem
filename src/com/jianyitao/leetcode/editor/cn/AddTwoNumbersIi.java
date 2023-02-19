  /**
You are given two non-empty linked lists representing two non-negative integers.
 The most significant digit comes first and each of their nodes contains a 
single digit. Add the two numbers and return the sum as a linked list. 

 You may assume the two numbers do not contain any leading zero, except the 
number 0 itself. 

 
 Example 1: 
 
 
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
 

 Example 2: 

 
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
 

 Example 3: 

 
Input: l1 = [0], l2 = [0]
Output: [0]
 

 
 Constraints: 

 
 The number of nodes in each linked list is in the range [1, 100]. 
 0 <= Node.val <= 9 
 It is guaranteed that the list represents a number that does not have leading 
zeros. 
 

 
 Follow up: Could you solve it without reversing the input lists? 

 Related Topics 栈 链表 数学 👍 577 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class AddTwoNumbersIi{
      public static void main(String[] args) {
          Solution solution = new AddTwoNumbersIi().new Solution();
           
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
    ListNode reverseLink(ListNode head){
        if(head == null ) return head;

        ListNode pre = null;         //当前指针的前一指针
        ListNode p = head;           //当前指针

        while(p != null){         //逆置
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    ListNode add(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){                                   //特殊情况
            return null;
        }
        if(l1.val == 0 && l1.next == null){
            return l2;
        }
        if(l2.val == 0 && l2.next == null){
            return l1;
        }

        ListNode ansHead = new ListNode();
        ListNode l3 = ansHead;                                     //头结点，不表示任何数
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Rev = reverseLink(l1);
        ListNode l2Rev = reverseLink(l2);

        return reverseLink(add(l1Rev,l2Rev));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


      class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
  }