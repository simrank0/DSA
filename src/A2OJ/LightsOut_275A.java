package A2OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LightsOut_275A {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int mat[][] = new int[3][3];
        int input[][] = new int[3][3];
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                input[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i<3; i++) {
            Arrays.fill(mat[i], 1);
        }
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(input[i][j]%2==1) {
                    mat[i][j] = 1 - mat[i][j];
                    if(j>0 && i>0) mat[i-1][j-1] = 1 - mat[i-1][j-1];
                    if(j<2 && i<2) mat[i+1][j+1] = 1 - mat[i+1][j+1];
                    if(j<2) mat[i][j+1] = 1 - mat[i][j+1];
                    if(j>0) mat[i][j-1] = 1 - mat[i][j-1];
                    if(j<2 && i>0) mat[i-1][j+1] = 1 - mat[i-1][j+1];
                    if(j>0 && i<2) mat[i+1][j-1] = 1 - mat[i+1][j-1];
                    if(i>0) mat[j][i-1] = 1 - mat[j][i-1];
                    if(i<2) mat[j][i+1] = 1 - mat[j][i+1];
                }
                for(int x = 0; x<3; x++)
                System.out.println(Arrays.toString(mat[x]));
                System.out.println("----------------");
            }
        }
        for(int i = 0; i<3; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
