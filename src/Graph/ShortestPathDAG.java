package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {
    static class Pair {
        int v, weight;

        Pair(int v, int w) {
            this.v = v;
            this.weight = w;
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        List<List<Pair>> adj_list = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            adj_list.add(new ArrayList<>());
        }
        adj_list.get(0).add(new Pair(1, 2));
        adj_list.get(0).add(new Pair(4, 1));
        adj_list.get(1).add(new Pair(2, 3));
        adj_list.get(2).add(new Pair(3, 6));
        adj_list.get(4).add(new Pair(2, 2));
        adj_list.get(4).add(new Pair(5, 4));
        adj_list.get(5).add(new Pair(3, 1));
        ShortestPathDAG shortestPathDAG = new ShortestPathDAG();
        shortestPathDAG.shortestPath(adj_list, n, 0);
    }

    void shortestPath(List<List<Pair>> adj, int n, int s) {
        Stack stack = new Stack();
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) topologicalSortUtil(i, vis, stack, adj);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        while (!stack.isEmpty()){
            int node = (int)stack.pop();
            if(dist[node] != Integer.MAX_VALUE){
                for (Pair it : adj.get(node)){
                    if(dist[it.getV()]> dist[node]+it.getWeight()){
                        dist[it.getV()] = dist[node] + it.getWeight();
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    void topologicalSortUtil(int i, boolean[] vis, Stack stack, List<List<Pair>> adj) {
        vis[i] = true;
        for(Pair it : adj.get(i)){
            if(!vis[it.getV()]) topologicalSortUtil(it.getV(), vis, stack, adj);
        }
        stack.add(i);
    }

}
