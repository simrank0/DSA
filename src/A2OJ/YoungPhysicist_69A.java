package A2OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YoungPhysicist_69A {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        long x=0, y=0, z=0;
        for(int i = 0; i<n; i++){
            x+= in.nextInt();
            y+= in.nextInt();
            z+= in.nextInt();
        }
        if(x==0 && y==0 && z==0) System.out.println("YES");
        else System.out.println("NO");
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
