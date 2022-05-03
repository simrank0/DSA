package Arrays;

import java.util.Arrays;

public class CountUnguardedCells {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] g = new char[m][n];
        for (int[] guard : guards) {
            g[guard[0]][guard[1]] = 'g';
        }
        for (int[] wall : walls) {
            g[wall[0]][wall[1]] = 'w';
        }

        for(int i = 0; i<g.length; i++){
            int mode = 0;
            for(int j = 0; j<g[0].length; j++){
                if(g[i][j]=='w'){
                    mode = 0;
                }else if(g[i][j]=='g'){
                    mode = 1;
                }else if(mode == 1) g[i][j] = 'p';
            }
        }

        for(int i = g.length-1; i>=0; i--){
            int mode = 0;
            for(int j = 0; j<g[0].length; j++){
                if(g[i][j]=='w'){
                    mode = 0;
                }else if(g[i][j]=='g'){
                    mode = 1;
                }else if(mode == 1) g[i][j] = 'p';
            }
        }

        for(int i = 0; i<g[0].length; i++){
            int mode = 0;
            for(int j = 0; j<g.length; j++){
                if(g[j][i]=='w'){
                    mode = 0;
                }else if(g[j][i]=='g'){
                    mode = 1;
                }else if(mode == 1) g[j][i] = 'p';
            }
        }

        for(int i = g[0].length-1; i>=0; i--){
            int mode = 0;

            for(int j = 0; j<g.length; j++){
                if(g[j][i]=='w'){
                    mode = 0;
                }else if(g[j][i]=='g'){
                    mode = 1;
                }else if(mode == 1) g[j][i] = 'p';
            }
        }



        int ans = 0;
        for (char[] chars : g) {
            System.out.println(Arrays.toString(chars));
            for (int j = 0; j < g[0].length; j++) {
                if (chars[j] != 'g' && chars[j] != 'w' && chars[j] != 'p') ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1},{2,2},{1,4}};
        System.out.println(countUnguarded(4, 6, guards, walls));
    }
}