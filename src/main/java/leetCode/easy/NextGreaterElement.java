import java.util.*;

public class NextGreaterElement{
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
          map.put(nums[i], i);
        }
        int k = 0;
        for(int i: findNums){
          int pos = map.get(i);
          boolean found = false;
          for(int j = pos + 1; j<nums.length && !found ;j++){
            if(nums[j] > i){
              found = true;
              res[k] = nums[j];
            }
          }
          if(!found){
            res[k] = -1;
          }
          k++;
        }
        return res;
    }
}
