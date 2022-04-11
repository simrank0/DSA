package Graphs;

import java.util.ArrayList;

public class Bridges {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);

        Bridges bridges = new Bridges();
        bridges.printBridges(adj, n);
    }

    void printBridges(ArrayList<ArrayList<Integer>> adj, int N){
        int[] vis = new int[N];
        int[] low = new int[N];
        int[] tim = new int[N];
        int timer = 0;
        for(int i = 0; i<N; i++){
            if(vis[i]==0){
                dfs(i, -1, vis, low, tim, adj, timer);
            }
        }
    }

    void dfs(int node, int parent, int[] vis, int[] low, int[] tim, ArrayList<ArrayList<Integer>> adj, int timer){
        vis[node] = 1;
        tim[node] = low[node] = timer++;

        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, vis, low, tim, adj, timer);
                low[node] = Math.min(low[it], low[node]);
                if(low[it]>low[node]) System.out.println(it + " " + node);
            }else{
                low[node] = Math.min(low[node], tim[it]);
            }
        }
    }
}
