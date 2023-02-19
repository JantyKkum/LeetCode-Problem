  /**
Given a binary tree, determine if it is height-balanced. 

 
 Example 1: 
 
 
Input: root = [3,9,20,null,null,15,7]
Output: true
 

 Example 2: 
 
 
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
 

 Example 3: 

 
Input: root = []
Output: true
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [0, 5000]. 
 -10⁴ <= Node.val <= 10⁴ 
 

 Related Topics 树 深度优先搜索 二叉树 👍 1224 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class BalancedBinaryTree{
      public static void main(String[] args) {
          Solution solution = new BalancedBinaryTree().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1 && isBalanced(root.left)
                &&isBalanced(root.right)  ){
            return true;
        }else{
            return false;
        }
    }


    public int treeHeight(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int h1 = treeHeight(root.left);
            int h2 = treeHeight(root.right);
            return Math.max(h1,h2) + 1;
        }
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
  }