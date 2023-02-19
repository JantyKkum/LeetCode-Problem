  /**
Given an array of strings strs, group the anagrams together. You can return the 
answer in any order. 

 An Anagram is a word or phrase formed by rearranging the letters of a 
different word or phrase, typically using all the original letters exactly once. 

 
 Example 1: 
 Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 
 Example 2: 
 Input: strs = [""]
Output: [[""]]
 
 Example 3: 
 Input: strs = ["a"]
Output: [["a"]]
 
 
 Constraints: 

 
 1 <= strs.length <= 10⁴ 
 0 <= strs[i].length <= 100 
 strs[i] consists of lowercase English letters. 
 

 Related Topics 数组 哈希表 字符串 排序 👍 1359 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.HashSet;
  import java.util.List;

  public class GroupAnagrams{
      public static void main(String[] args) {
          Solution solution = new GroupAnagrams().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<List> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> innerList = new ArrayList<>();
            innerList.add(strs[i]);
            for (int j = 0; j < strs.length; j++) {
                if(isAnagram(strs[i],strs[j])) innerList.add(strs[j]);
            }
            set.add(innerList);
        }
        for (List list : set) {
            ans.add(list);
        }
        return ans;
    }

    boolean isAnagram(String str1,String str2){
        HashSet<Character> hs1 = new HashSet<>();
        HashSet<Character> hs2 = new HashSet<>();
        for (char c : str1.toCharArray()) {
            hs1.add(c);
        }
        for (char c : str2.toCharArray()) {
            hs2.add(c);
        }
        return hs1.equals(hs2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }