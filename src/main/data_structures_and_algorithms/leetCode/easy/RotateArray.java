package data_structures_and_algorithms.leetCode.easy;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (k>=nums.length) k=k%(nums.length);
        int[] rem=new int[k];
        int j=0;
        for(int i=nums.length-k;i<nums.length;i++){
            rem[j++]=nums[i];
        }
        
        for(int i=nums.length-1;i>=k;i--){
            nums[i]=nums[i-k];
        }
        for(int i=0;i<rem.length;i++)
            nums[i]=rem[i];
    }

}
