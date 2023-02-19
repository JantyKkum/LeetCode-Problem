  /**
In an alien language, surprisingly, they also use English lowercase letters, 
but possibly in a different order. The order of the alphabet is some permutation 
of lowercase letters. 

 Given a sequence of words written in the alien language, and the order of the 
alphabet, return true if and only if the given words are sorted 
lexicographically in this alien language. 

 
 Example 1: 

 
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is 
sorted.
 

 Example 2: 

 
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], 
hence the sequence is unsorted.
 

 Example 3: 

 
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is 
shorter (in size.) According to lexicographical rules "apple" > "app", because 
'l' > '∅', where '∅' is defined as the blank character which is less than any 
other character (More info).
 

 
 Constraints: 

 
 1 <= words.length <= 100 
 1 <= words[i].length <= 20 
 order.length == 26 
 All characters in words[i] and order are English lowercase letters. 
 

 Related Topics 数组 哈希表 字符串 👍 230 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class VerifyingAnAlienDictionary{
      public static void main(String[] args) {
          Solution solution = new VerifyingAnAlienDictionary().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        boolean ans = true;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c1 = words[i].charAt(j);
                char c2;
                if(j > words[i+1].length()-1){
                    ans = false;
                    break;
                }else{
                    c2 = words[i+1].charAt(j);
                }

                if(order.indexOf(c1) == order.indexOf(c2)){
                    continue;
                }else if(order.indexOf(c1) < order.indexOf(c2)){
                    break;
                }else if(order.indexOf(c1) > order.indexOf(c2)){
                    ans = false;
                    break;
                }
            }
            if(ans == false){
                break;
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }