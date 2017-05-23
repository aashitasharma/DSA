package data_structures_and_algorithms.leetCode.medium;

public class JumpGame {

    public boolean canJump(int[] nums) {
	boolean res = true;
	int p = nums.length - 1;
	for (int i = nums.length - 2; i >= 0; i--) {
	    if (p - i <= nums[i]) {
		p = i;
		res = true;
	    } else
		res = false;
	}
	return res;
    }

}
