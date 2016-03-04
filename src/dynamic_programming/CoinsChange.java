package dynamic_programming;

public class CoinsChange {

    public CoinsChange() {
	// TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	long[] a={1,2,6,7};
	System.out.println(coins_change(a, 2));
    }
    
    static int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;
         
        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;
     
        // If there are no coins and n is greater than 0, then no solution exist
        if (m <=0 && n >= 1)
            return 0;
     
        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
    }
    
    /**
     * count number of wasy to get sum of n with given array
     * TODO
     * O(mn) in space and time
     * But can be done in O(n) space
     * @param a
     * @param n
     * @return
     */
    public static long coins_change(long[] a, int n){
   	long [][] dp=new long[a.length+1][n+1];
   	for(int i=0;i<dp.length;i++)
   	    dp[i][0]=1;
   	for(int i=1;i<dp.length;i++){
   	    for(int j=0;j<dp[0].length;j++){
   		if(j>=a[i-1]){
   		    dp[i][j]=dp[i-1][j]+dp[i][(int) (j-a[i-1])];
   		}
   		else{
   		   dp[i][j]=dp[i-1][j];
   		}
   		    
   	    }
   	}
   	return dp[dp.length-1][dp[0].length-1];
       }

}
