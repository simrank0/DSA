package Graphs;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj_list = new ArrayList<>();
        int n = 7;
        for(int i = 0; i<= n; i++){
            adj_list.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {2, 7}, {2, 3}, {3, 5}, {5, 7}, {6, 7}, {5, 6}, {4, 6}};

        //  1- 2 - 7
        //     |   | \
        //     3 - 5 - 6 - 4

        for (int[] edge : edges) {
            List<Integer> l = adj_list.get(edge[0]);
            l.add(edge[1]);
            adj_list.set(edge[0], l);
            l = adj_list.get(edge[1]);
            l.add(edge[0]);
            adj_list.set(edge[1], l);
        }

        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        System.out.println("BFS says: " + bipartiteGraph.checkBipartiteBFS(adj_list, n));
        System.out.println("DFS says: " + bipartiteGraph.checkBipartiteDFS(adj_list, n));
    }

    boolean checkBipartiteBFS(List<List<Integer>> adj, int n){
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        for(int i = 1; i<=n; i++){
            if(color[i]==-1){
                if(!checkBFS(adj, color, i)) return false;
            }
        }
        return true;
    }

    boolean checkBFS(List<List<Integer>> adj, int[] color, int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(int n: adj.get(node)){
                if(color[n] == -1){
                    color[n] = 1 - color[node];
                    q.add(n);
                }else if(color[n] == color[node]) return false;
            }
        }
        return true;
    }
    boolean checkBipartiteDFS(List<List<Integer>> adj, int n){
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        for(int i = 1; i<=n; i++){
            if(color[i]==-1){
                if(!checkDFS(adj, color, i)) return false;
            }
        }
        return true;
    }

    boolean checkDFS(List<List<Integer>> adj, int[] color, int i){
        if(color[i] == -1) color[i] = 1;
        for(Integer it : adj.get(i)){
            if(color[it] == -1) {
                color[it] = 1 - color[i];
                if(!checkDFS(adj, color, it)) return false;
            }else if(color[it] == color[i]) return false;
        }
        return true;
    }
}
