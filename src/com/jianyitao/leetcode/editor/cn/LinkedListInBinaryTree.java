  /**
Given a binary tree root and a linked list with head as the first node.

 Return True if all the elements in the linked list starting from the head
correspond to some downward path connected in the binary tree otherwise return False.


 In this context downward path means a path that starts at some node and goes
downwards.


 Example 1:




Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.


 Example 2:




Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
null,1,3]
Output: true


 Example 3:


Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,
null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements
of the linked list from head.



 Constraints:


 The number of nodes in the tree will be in the range [1, 2500].
 The number of nodes in the list will be in the range [1, 100].
 1 <= Node.val <= 100 for each node in the linked list and binary tree.


 Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 162 👎 0

*/

  package com.jianyitao.leetcode.editor.cn;

  import org.junit.jupiter.api.Test;

  import java.util.Stack;

  public class LinkedListInBinaryTree{
      public static void main(String[] args) {
          Solution solution = new LinkedListInBinaryTree().new Solution();

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return DFS(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }
    @Test
    public boolean DFS(ListNode head, TreeNode root){
        if(head == null) return true;
        if(root == null) return false;
        if(root.val != head.val) return false;
        return DFS(head.next,root.left) || DFS(head.next,root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
     }

      public class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }
  }