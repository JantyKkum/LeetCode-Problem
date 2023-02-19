  /**
Given an array of points where points[i] = [xi, yi] represents a point on the X-
Y plane and an integer k, return the k closest points to the origin (0, 0). 

 The distance between two points on the X-Y plane is the Euclidean distance (i.
e., √(x1 - x2)² + (y1 - y2)²). 

 You may return the answer in any order. The answer is guaranteed to be unique (
except for the order that it is in). 

 
 Example 1: 
 
 
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-
2,2]].
 

 Example 2: 

 
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

 
 Constraints: 

 
 1 <= k <= points.length <= 10⁴ 
 -10⁴ < xi, yi < 10⁴ 
 

 Related Topics 几何 数组 数学 分治 快速选择 排序 堆（优先队列） 👍 378 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.*;

  public class KClosestPointsToOrigin{
      public static void main(String[] args) {
          Solution solution = new KClosestPointsToOrigin().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return eDistance(o1) - eDistance(o2);
            }
        });
        for (int i = 0; i < k; i++) {
            ans[i] = points[i];
        }
//        PriorityQueue priorityQueue = new PriorityQueue;
//        Collections.sort(points,new Comparator<>(){});
////        int[] ints = new int[points.length];
//        TreeMap<Integer, int[]> map = new TreeMap<>();
//        for (int i = 0; i < points.length; i++) {
//            map.put(eDistance(points[i]),points[i]);
//        }
//        Collections.sort(map.keySet());

        return ans;
    }

    int eDistance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }