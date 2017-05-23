package data_structures_and_algorithms.leetCode.easy;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int low=0;
        int high=s.length()-1;
        while(low<high){
            char low_ch=s.charAt(low);
            char high_ch=s.charAt(high);
            if(!isAlphanumeric(low_ch)){
                low++;
                continue;
            }
            if(!isAlphanumeric(high_ch)){
                high--;
                continue;
            }
            if(low_ch!=high_ch)
                return false;
            low++;
            high--;
        }
        return true;
    }
    
    private static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

}
