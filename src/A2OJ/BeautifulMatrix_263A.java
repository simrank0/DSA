package A2OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautifulMatrix_263A {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int[][] a = new int[5][5];
        int indI = -1, indJ = -1;
        for(int i = 0; i<5; i++) {
            for(int j = 0; j<5; j++) {
                a[i][j] = in.nextInt();
                if(a[i][j]==1) {
                    indI = i;
                    indJ = j;
                }
            }
        }
        System.out.println(Math.abs(indI-2) + Math.abs(indJ-2));
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
