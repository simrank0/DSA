package Graphs;

import java.util.ArrayList;

public class ArticulationPoint {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
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

        // 0 - 1 - 3
        // |  /    |
        //  2      4

        ArticulationPoint obj = new ArticulationPoint();
        obj.printArticulation(adj, n);
    }

    void printArticulation(ArrayList<ArrayList<Integer>> adj, int N){
        int[] vis = new int[N];
        int[] tim = new int[N];
        int[] low = new int[N];

        int isArticulation[] = new int[N];

        int timer = 0;
        for(int i = 0; i<N; i++){
            if(vis[i]==0)dfs(i, -1, adj, vis, tim, low, timer, isArticulation);
        }

        for(int i=0; i<N; i++) if(isArticulation[i]==1) System.out.print(i + " ");

    }

    void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] tim, int[] low, int timer, int[] isArticulation){
        vis[node] = 1;
        tim[node] = low[node] = timer++;
        int child = 0;
        for(Integer it: adj.get(node)){
            if(it == parent) continue;;
            if(vis[it]==0){
                dfs(it, node, adj, vis, tim, low, timer, isArticulation);
                low[node] = Math.min(low[it], low[node]);
                if(low[it]>=tim[node] && parent != -1) isArticulation[node] = 1;
                child++;
            }else {
                low[node] = Math.min(tim[it], low[node]);
            }
        }
        if(parent == -1 && child>1) isArticulation[node] = 1;
    }
}
