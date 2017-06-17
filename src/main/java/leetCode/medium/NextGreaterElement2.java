
public class NextGreaterElement2{
  public int[] nextGreaterElements(int[] nums) {
      int[] res = new int[nums.length];
      int k=0;
      for(int i=0;i<nums.length;i++){
        res[k++] = iterate(i, nums);
      }
      return res;
  }

  private int iterate(int startpos, int[] nums){
    int target = nums[startpos];
    int start = startpos + 1;
    while(start!=startpos){
      if(start >= nums.length){
        start = 0;
        continue;
      }
      if(nums[start] > target){
        return nums[start];
      }
      start++;
    }
    return -1;
  }

  //TODO: finish this
  public int[] nextGreaterElementUsingStack(int[] nums){
      return new int[1];
  }
}
