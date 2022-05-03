package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements {
    static ArrayList<Integer> commonElements(int[] A, int[] B, int[] C, int n1, int n2, int n3)
    {
        // code here
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> a = new ArrayList<>();
        while(i<n1 && j<n2 && k<n3){
            if(A[i]==B[j] && B[j]==C[k]){
                if(!a.contains(A[i]))a.add(A[i]);
                i++; j++; k++;
            }
            else if(A[i]<=B[j] && A[i]<=C[k]) i++;
            else if(B[j]<=A[i] && B[j]<=C[k]) j++;
            else k++;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int[] A = new int[n1];
        int[] B = new int[n2];
        int[] C = new int[n3];
        int i = 0;
        while(i<n1) {
            A[i] = in.nextInt();
            i++;
        }
        i = 0;
        while(i<n2) {
            B[i] = in.nextInt();
            i++;
        }
        i = 0;
        while(i<n3) {
            C[i] = in.nextInt();
            i++;
        }

        System.out.println(commonElements(A, B, C, n1, n2, n3));
    }
}
