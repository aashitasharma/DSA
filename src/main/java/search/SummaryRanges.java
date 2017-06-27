package leetCode.medium;
import java.util.*;
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result=new LinkedList<String>();
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        if(nums==null || nums.length==0) return result;
        if(nums.length==1){
            result.add(nums[0]+"");
            return result;
        }
        for(int i=0;i<nums.length-1;i++){
            if(-nums[i]+nums[i+1]==1){
                if(flag==false){
                    sb.append(nums[i]+"").append("->");
                    flag=true;                
                }
            }
            else{
                sb.append(nums[i]+"");
                result.add(sb.toString());
                sb.delete(0, sb.length());
                flag=false;
            }
        }
        if(nums[nums.length-1]-nums[nums.length-2]==1){
            sb.append(nums[nums.length-1]);
            result.add(sb.toString());
        }
        else
            result.add(nums[nums.length-1]+"");
        return result;
    }

}
