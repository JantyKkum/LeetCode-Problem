  /**
A sequence of numbers is called arithmetic if it consists of at least two 
elements, and the difference between every two consecutive elements is the same. More 
formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0]
 for all valid i. 

 For example, these are arithmetic sequences: 

 
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9 

 The following sequence is not arithmetic: 

 
1, 1, 2, 5, 7 

 You are given an array of n integers, nums, and two arrays of m integers each, 
l and r, representing the m range queries, where the iᵗʰ query is the range [l[
i], r[i]]. All the arrays are 0-indexed. 

 Return a list of boolean elements answer, where answer[i] is true if the 
subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an 
arithmetic sequence, and false otherwise. 

 
 Example 1: 

 
Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
Output: [true,false,true]
Explanation:
In the 0ᵗʰ query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], 
which is an arithmetic sequence.
In the 1ˢᵗ query, the subarray is [4,6,5,9]. This cannot be rearranged as an 
arithmetic sequence.
In the 2ⁿᵈ query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9]
, which is an arithmetic sequence. 

 Example 2: 

 
Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [
4,4,9,7,9,10]
Output: [false,true,false,false,true,true]
 

 
 Constraints: 

 
 n == nums.length 
 m == l.length 
 m == r.length 
 2 <= n <= 500 
 1 <= m <= 500 
 0 <= l[i] < r[i] < n 
 -10⁵ <= nums[i] <= 10⁵ 
 

 Related Topics 数组 排序 👍 26 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import com.sun.scenario.effect.Reflection;

  import javax.accessibility.Accessible;
  import java.io.File;
  import java.lang.reflect.Constructor;
  import java.lang.reflect.Field;
  import java.lang.reflect.InvocationTargetException;
  import java.lang.reflect.Method;
  import java.util.*;

  public class ArithmeticSubarrays{
      public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
          Solution solution = new ArithmeticSubarrays().new Solution();
          String classPath = "com.jianyitao.leetcode.editor.cn.doc.Cat";
          Class cls= Class.forName(classPath);
          Object o = cls.newInstance();
          Field name = cls.getDeclaredField("name");
          name.setAccessible(true);
          System.out.println(name.getName());
          Method getName = cls.getMethod("getName");
          System.out.println(getName.invoke(o));
          name.set(o,"billjian");
          System.out.println(getName.invoke(o));

          System.out.println("=====");
          Class class2 = Class.forName(String.valueOf(File.class.getName()));
          Constructor[] constructors = class2.getDeclaredConstructors();
          for (Constructor constructor : constructors) {
              System.out.println(constructor);
          }
          Constructor constructor = class2.getDeclaredConstructor(String.class);
          String filePath = "F:\\aa.txt";
          Object file = constructor.newInstance(filePath);

          Method createNerFile = class2.getMethod("createNewFile");
          createNerFile.invoke(file);

          System.out.println(file.getClass());
          System.out.println(filePath);


      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            ans.add(arithmeticSequence(nums,l[i],r[i]));
        }
        return ans;
    }

    boolean arithmeticSequence(int[] nums, int left, int right){
        int[] subNums = new int[right-left+1];
        subNums = Arrays.copyOfRange(nums,left,right+1);
        Arrays.sort(subNums);
        for (int i = 1; i < subNums.length-1; i++) {
            if(subNums[i+1]-subNums[i] != subNums[1]-subNums[0]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }