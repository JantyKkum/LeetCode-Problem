  /**
You are given a string s formed by digits and '#'. We want to map s to English 
lowercase characters as follows: 

 
 Characters ('a' to 'i') are represented by ('1' to '9') respectively. 
 Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
 

 Return the string formed after mapping. 

 The test cases are generated so that a unique mapping will always exist. 

 
 Example 1: 

 
Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 

 Example 2: 

 
Input: s = "1326#"
Output: "acz"
 

 
 Constraints: 

 
 1 <= s.length <= 1000 
 s consists of digits and the '#' letter. 
 s will be a valid string such that mapping is always possible. 
 

 Related Topics 字符串 👍 76 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class DecryptStringFromAlphabetToIntegerMapping{
      public static void main(String[] args) {
          Solution solution = new DecryptStringFromAlphabetToIntegerMapping().new Solution();
          solution.freqAlphabets("10#11#12");
//          String s = "23";
//          char a = '2';
//          System.out.println(a+1);
//          char b = '7';
//          System.out.println(b+1);
//          System.out.println((int)s.charAt(1)*10 + (int)s.charAt(0));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder ans = new StringBuilder();
        char[] record =new char[27];
        for (int i = 0; i < s.length(); i++) {
            if (i+2 < s.length() && s.charAt(i+2) == '#' ){
                ans.append( (char) ((s.charAt(i)-'0')*10 + s.charAt(i+1)-'0' + 'a' - 1) );
                i += 2;
            }else{
                ans.append( (char) (s.charAt(i)-'0'+ 'a' - 1));
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }