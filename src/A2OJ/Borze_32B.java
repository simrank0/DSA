package A2OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Borze_32B {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.next();
        char prev = 'a';
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i<s.length(); i++) {
            if(prev == 'a' && s.charAt(i)=='.') ans.append(0);
            else if(prev == '-'){
                prev = 'a';
                if(s.charAt(i)=='.') {
                    ans.append(1);
                } else ans.append(2);
            } else {
                prev = s.charAt(i);
            }
        }
        System.out.println(ans);
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
