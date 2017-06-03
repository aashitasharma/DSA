package leetCode.medium;

public class RemoveDuplicateFromSortedArray2 {

    public RemoveDuplicateFromSortedArray2() {
	// TODO Auto-generated constructor stub
    }

    public int removeDuplicates(int[] nums) {
	int k = 1;
	int sub_count = 1;
	if (nums.length == 0)
	    return 0;
	int temp = nums[0];
	for (int i = 1; i < nums.length; i++) {
	    if (nums[i] == temp) {
		sub_count++;
		if (sub_count <= 2)
		    nums[k++] = nums[i];
	    } else {
		sub_count = 1;
		nums[k++] = nums[i];
	    }
	    temp = nums[i];
	}
	return k;
    }

}
