  /**
Given head which is a reference node to a singly-linked list. The value of each 
node in the linked list is either 0 or 1. The linked list holds the binary 
representation of a number. 

 Return the decimal value of the number in the linked list. 

 The most significant bit is at the head of the linked list. 

 
 Example 1: 
 
 
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
 

 Example 2: 

 
Input: head = [0]
Output: 0
 

 
 Constraints: 

 
 The Linked List is not empty. 
 Number of nodes will not exceed 30. 
 Each node's value is either 0 or 1. 
 

 Related Topics 链表 数学 👍 136 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class ConvertBinaryNumberInALinkedListToInteger{
      public static void main(String[] args) {
          Solution solution = new ConvertBinaryNumberInALinkedListToInteger().new Solution();
           
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
    MiddleOfTheLinkedList.ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, MiddleOfTheLinkedList.ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int n = 0, ans = 0;
        while(cur != null){
//            cur = cur.next;
            n++;
        }
        int i = n-1;
        cur = head;
        while (cur != null){
            ans += cur.val * Math.pow(2,i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }