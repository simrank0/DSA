package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
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
        System.out.println(dfs(adj_list, n));
    }
    static ArrayList<Integer> dfs(List<List<Integer>> adj_list, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            if(!vis[i]) {
                dfs_helper(i, adj_list, vis, ans);
            }
        }
        return ans;
    }
    static void dfs_helper(int node, List<List<Integer>> adj_list, boolean[] vis, ArrayList<Integer> ans){
        ans.add(node);
        vis[node] = true;
        for(Integer it: adj_list.get(node)){
            if(!vis[it]){
                dfs_helper(it, adj_list, vis, ans);
            }
        }
    }
}
