package leetCode.medium;

public class ReverseWords {
	public static void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        int p=0;
        for(int i=0;i<s.length;i++){
            if(s[i]==' '){
                reverse(s,p,i);
                p=i+1;
            }
        }
    }
    public static void reverse(char[] s, int low, int high){
        while(low<high){
            char temp=s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s={'t','h','e',' ', 's','k','y',' ', 'i','s',' ', 'b','l','u','e'};
		reverseWords(s);
		System.out.println(s.toString());
	}

}
