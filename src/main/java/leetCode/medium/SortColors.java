package leetCode.medium;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] colors_count=new int[3];
        for(int i:nums){
            colors_count[i]++;
        }
        int k=0;
        for(int i=0;i<nums.length;){
            while(colors_count[k]!=0){
                nums[i++]=k;
                colors_count[k]--;
            }
            k++;
        }
    }

}
