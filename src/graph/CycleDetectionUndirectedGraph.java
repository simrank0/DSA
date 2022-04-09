package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionUndirectedGraph {
    static class Node{
        int a, b;
        Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
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
        System.out.println("DFS says: " + isCycleDFS(adj_list, n));
        System.out.println("BFS says: " + isCycleBFS(adj_list, n));

    }

    static boolean isCycleDFS(List<List<Integer>> adj_list, int n){
        boolean[] vis = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            if(!vis[i]){
                if(checkForCycleDFS(i, -1, adj_list, vis)) return true;
            }
        }
        return false;
    }

    static boolean checkForCycleDFS(int i, int par, List<List<Integer>> adj_list, boolean[] vis){
        vis[i] = true;
        for(Integer it: adj_list.get(i)){
            if(!vis[it]){
                if(checkForCycleDFS(it, i, adj_list, vis)) return true;
            }else if(it != par) return true;
        }
        return false;
    }
    static boolean isCycleBFS(List<List<Integer>> adj_list, int n){
        boolean[] vis = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            if(!vis[i]){
                if(checkForCycleBFS(i, adj_list, vis)) return true;
            }
        }
        return false;
    }
    static boolean checkForCycleBFS(int i, List<List<Integer>> adj_list, boolean[] vis){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, -1));
        vis[i] = true;
        while(!q.isEmpty()){
            int node = q.peek().a;
            int par = q.peek().b;
            q.poll();
            for(Integer it: adj_list.get(node)){
                if(!vis[it]){
                    q.add(new Node(it,node));
                    vis[it] = true;
                }else if(par != it) return true;
            }
        }
        return false;
    }
}
