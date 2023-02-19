  /**
Given the root of a binary tree, return its maximum depth. 

 A binary tree's maximum depth is the number of nodes along the longest path 
from the root node down to the farthest leaf node. 

 
 Example 1: 
 
 
Input: root = [3,9,20,null,null,15,7]
Output: 3
 

 Example 2: 

 
Input: root = [1,null,2]
Output: 2
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [0, 10⁴]. 
 -100 <= Node.val <= 100 
 

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1464 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import javax.swing.tree.TreeNode;

  public class MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
          Solution solution = new MaximumDepthOfBinaryTree().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)

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

class Solution {
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if(root == null){
            return ans;
        }else{
            ans = Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }