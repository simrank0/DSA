package A2OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QueueAtTheSchool_266B {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int t = in.nextInt();
        String s = in.next();
        char[] ch = s.toCharArray();
        char[] temp = ch.clone();
        for(int i = 0; i<t; i++) {
            for(int j = 0; j<s.length()-1; j++) {
                if(ch[j]=='G' || ch[j+1]=='B') continue;
                temp[j+1] = 'B';
                temp[j] = 'G';
            }
            ch = temp.clone();
        }

        System.out.println(new String(ch));
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
