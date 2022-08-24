// { Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int a[] , int n)
    {
        //add code here.
        Arrays.sort(a);
        for(int i = 0; i<n-2; i++) {
            int start = i + 1; 
            int end = n - 1;
            while(start<end) {
                if(a[i]+a[start]+a[end]==0) return true;
                if(a[i]+a[start]+a[end] < 0) {
                    start++;
                }else end--;
            }
        }
        return false;
    }
}