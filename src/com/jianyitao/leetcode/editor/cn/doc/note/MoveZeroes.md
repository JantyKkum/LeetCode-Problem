主要考虑双指针，交换数据内容，或者快排思想，将pivot设置为0，小于等于0放置右侧，大于0的放置于左侧

应该正确的另一种做法（被判错）

class Solution {
public void moveZeroes(int[] nums) {
List list = new ArrayList();
int zeroCount = 0;
for (int i = 0; i < nums.length; i++) {
if(nums[i] == 0){
zeroCount++;
}else{
list.add(nums[i]);
}
}
for (int j = 0; j < zeroCount; j++) {
list.add(0);
}
System.out.println(list);

    }
}