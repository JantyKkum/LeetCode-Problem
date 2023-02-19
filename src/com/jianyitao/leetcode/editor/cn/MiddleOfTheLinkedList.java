  /**
Given the head of a singly linked list, return the middle node of the linked 
list. 

 If there are two middle nodes, return the second middle node. 

 
 Example 1: 
 
 
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
 

 Example 2: 
 
 
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return 
the second one.
 

 
 Constraints: 

 
 The number of nodes in the list is in the range [1, 100]. 
 1 <= Node.val <= 100 
 

 Related Topics 链表 双指针 👍 771 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class MiddleOfTheLinkedList{
      public static void main(String[] args) {
          Solution solution = new MiddleOfTheLinkedList().new Solution();

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
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        ListNode ans = head;
        for (int i = 0; i < (length)/2; i++) {
            ans = ans.next;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }