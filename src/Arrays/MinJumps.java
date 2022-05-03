package Arrays;

public class MinJumps {
    static int minJumps(int[] arr){
        // your code here
        int i = 0, n = arr.length;
        int count = 0;
        if(n ==1)return 0;
        if(arr[0] == 0)return -1;
        while(i<n){
            int temp = arr[i];
            if(temp == 0 )return -1;
            if((i+temp+1)>=n)return count+1;
            int step = 0;
            int maxStep = 0;
            for(int j = 1; j<=temp;j++){
                if((j+arr[i+j])>=maxStep){
                    maxStep=j+arr[i+j];
                    step = j;
                }
            }
            i = i+step;


            count++;

        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(arr));
    }
}
