  /**
You are given an integer array arr. Sort the integers in the array in ascending 
order by the number of 1's in their binary representation and in case of two or 
more integers have the same number of 1's you have to sort them in ascending 
order. 

 Return the array after sorting it. 

 
 Example 1: 

 
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
 

 Example 2: 

 
Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should 
just sort them in ascending order.
 

 
 Constraints: 

 
 1 <= arr.length <= 500 
 0 <= arr[i] <= 10⁴ 
 

 Related Topics 位运算 数组 计数 排序 👍 158 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.*;

  public class SortIntegersByTheNumberOf1Bits{
      public static void main(String[] args) {
          Solution solution = new SortIntegersByTheNumberOf1Bits().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for(int i : arr){
            list.add(i);
            bit[i] = count1(i);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                if(count1(o1) != count1(o2)){
                    return count1(o1) - count1(o2);
                }else{
                    return o1-o2;
                }
            }
        });

        for(int i = 0; i<n; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    public int count1(int x){
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += x % 2;
            x = x/2;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }