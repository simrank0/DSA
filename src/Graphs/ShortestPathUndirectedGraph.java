package Graphs;

import java.util.*;

public class ShortestPathUndirectedGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj_list = new ArrayList<>();
        int n = 7;
        for(int i = 0; i<= n; i++){
            adj_list.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {2, 7}, {2, 3}, {3, 5}, {5, 7}, {1, 4}, {4, 6}};
        for (int[] edge : edges) {
            List<Integer> l = adj_list.get(edge[0]);
            l.add(edge[1]);
            adj_list.set(edge[0], l);
            l = adj_list.get(edge[1]);
            l.add(edge[0]);
            adj_list.set(edge[1], l);
        }
        shortestPath(adj_list, n, 1);
    }

    static void shortestPath(List<List<Integer>> adj, int n, int s){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(Integer it : adj.get(node)){
                if(dist[it]> dist[node]+1){
                    dist[it] = dist[node]+1;
                    q.add(it);
                }
            }
        }

        for (int i=1; i<=n; i++){
            System.out.print( dist[i] + " ");
        }
    }
}
