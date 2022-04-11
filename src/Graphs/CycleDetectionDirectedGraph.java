package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionDirectedGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj_list = new ArrayList<>();
        int n = 7;
        for(int i = 0; i<= n; i++){
            adj_list.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {2, 7}, {2, 3}, {3, 5}, {5, 7}, {7, 2}};

        //  1 -> 2 <-> 7
        //       |     |
        //       3  -> 5

        for (int[] edge : edges) {
            List<Integer> l = adj_list.get(edge[0]);
            l.add(edge[1]);
            adj_list.set(edge[0], l);
        }
        CycleDetectionDirectedGraph cycleDetectionDirectedGraph = new CycleDetectionDirectedGraph();
        System.out.println(cycleDetectionDirectedGraph.checkForCycleDFS(adj_list, n));
        System.out.println(cycleDetectionDirectedGraph.checkForCycleBFS(adj_list, n));
    }

    boolean checkForCycleDFS(List<List<Integer>> adj, int n){
        int[] vis = new int[n+1];
        int[] dfsVis = new int[n+1];
        for(int i = 0; i<=n; i++){
            if(vis[i]==0){
                if(checkCycleDFS(adj, vis, dfsVis, i)) return true;
            }
        }
        return false;
    }

    boolean checkCycleDFS(List<List<Integer>> adj, int[] vis, int[] dfsVis, int i){
        vis[i] = 1;
        dfsVis[i] = 1;
        for(Integer it: adj.get(i)){
            if(vis[it] == 0) {
                if(checkCycleDFS(adj, vis, dfsVis, it)) return true;
            }else if(dfsVis[it]==1) return true;
        }
        dfsVis[i] = 0;
        return false;
    }

    boolean checkForCycleBFS(List<List<Integer>> adj, int n){
        int[] indegree = new int[n+1];
        for(int i = 1; i<=n ; i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i]==0) q.add(i);
        }
        int c = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            c++;
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(c==n) return false;
        return true;
    }
}
