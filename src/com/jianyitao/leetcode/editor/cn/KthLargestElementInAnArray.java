  /**
Given an integer array nums and an integer k, return the kᵗʰ largest element in 
the array. 

 Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
distinct element. 

 You must solve it in O(n) time complexity. 

 
 Example 1: 
 Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
 
 Example 2: 
 Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 
 
 Constraints: 

 
 1 <= k <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 

 Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2034 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.Random;

  public class KthLargestElementInAnArray{
      public static void main(String[] args) {
          Solution solution = new KthLargestElementInAnArray().new Solution();
          int[] a = new int[]{9,8,6,7,3,4,5,0,1,2};
          for (int i : a) {
              System.out.print(i+" ");
          }
          System.out.println("======");
//          solution.quickSort(a,0,9);
//          solution.findKthLargest(a,3);
          for (int i : a) {
              System.out.print(i+" ");
          }
           
      }


      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums,0,n-1,n-k);
    }

    int quickSort(int[] nums, int left, int right,int k){

        int p = partition(nums, left, right);
        if (k < p){
            return quickSort(nums,left,p-1,k);
        }else if(p < k){
            return quickSort(nums,p+1, right,k);
        }else{
            return nums[p];
        }
    }

//          void quickSort(int[] nums, int left, int right){
//
//              if(left<right){
//                  int p = partition(nums, left, right);
//                  quickSort(nums,left,p-1);
//                  quickSort(nums,p+1, right);
//
//              }
//          }

    int partition(int[] a, int left, int right){
        int i = left,j=right,pivot = left + (int)(Math.random()*(right-left+1));
        swap(a,left,pivot);
        while(i<j){
            while (i<j && a[j] > a[left]) j--;
            while (i<j && a[i] <= a[left]) i++;
            if(i<j) swap(a,i,j);
        }
        swap(a,i,left);
        return i;
    }

    void swap (int[] arr,int index_a, int index_b) {
      int temp = arr[index_a];
      arr[index_a] = arr[index_b];
      arr[index_b] = temp;
    };


}
//leetcode submit region end(Prohibit modification and deletion)

  }