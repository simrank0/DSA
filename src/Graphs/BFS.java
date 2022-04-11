package Graphs;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        List<List<Integer>> adj_list = new ArrayList<>();
        int n = 7;
        for(int i = 0; i<= n; i++){
            adj_list.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {2, 7}, {2, 3}, {3, 5}, {5, 7}, {4, 6}};
        for (int[] edge : edges) {
            List<Integer> l = adj_list.get(edge[0]);
            l.add(edge[1]);
            adj_list.set(edge[0], l);
            l = adj_list.get(edge[1]);
            l.add(edge[0]);
            adj_list.set(edge[1], l);
        }
        System.out.println(bfs(adj_list, n));
    }

    static ArrayList<Integer> bfs(List<List<Integer>> adj_list, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            if(!vis[i]){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;
                while(!q.isEmpty()){
                    Integer node = q.poll();
                    ans.add(node);
                    for(Integer it : adj_list.get(node)){
                        if(!vis[it]){
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
