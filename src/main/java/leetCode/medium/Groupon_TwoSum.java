package leetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Groupon_TwoSum {

    public int[] twoSum(int[] nums, int target) {
	Map<Integer, Integer> set = new HashMap<Integer, Integer>();
	int[] result = new int[2];
	for (int i = 0; i < nums.length; i++) {
	    set.put(nums[i], i + 1);
	}
	for (int i = 0; i < nums.length; i++) {
	    int n = target - nums[i];
	    if (set.containsKey(n) && (i + 1) != set.get(n)) {

		result[0] = Math.min(i + 1, set.get(n));
		result[1] = Math.max(i + 1, set.get(n));
		break;
	    }
	}
	return result;
    }
}
