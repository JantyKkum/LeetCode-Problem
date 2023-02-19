  /**
You are given two strings word1 and word2. Merge the strings by adding letters 
in alternating order, starting with word1. If a string is longer than the other, 
append the additional letters onto the end of the merged string. 

 Return the merged string. 

 
 Example 1: 

 
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
 

 Example 2: 

 
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
 

 Example 3: 

 
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
 

 
 Constraints: 

 
 1 <= word1.length, word2.length <= 100 
 word1 and word2 consist of lowercase English letters. 
 

 Related Topics 双指针 字符串 👍 74 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class MergeStringsAlternately{
      public static void main(String[] args) {
          Solution solution = new MergeStringsAlternately().new Solution();
          String a = "gmumn";
          String b = "azia";
          System.out.println(a.substring(4));
          StringBuilder ans = new StringBuilder(10);
          ans.append(a.substring(4));
          System.out.println("ans:"+ans.toString());
          System.out.println(solution.mergeAlternately(a, b));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        StringBuilder ans = new StringBuilder(m+n);
        int i = 0,j = 0;
        while(m-- > 0 && n-- > 0){
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }
        if(m>=0){
            ans.append(word1.substring(i));
        }
        if(n>=0){
            ans.append(word2.substring(j));
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }