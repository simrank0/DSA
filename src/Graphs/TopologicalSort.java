package Graphs;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> adj_list = new ArrayList<>();
        int n = 7;
        for(int i = 0; i<= n; i++){
            adj_list.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {2, 7}, {2, 3}, {3, 5}, {5, 7}, {4, 6}};

        //  1 -> 2  -> 7  4 -> 6
        //       |     |
        //       3  -> 5

        for (int[] edge : edges) {
            List<Integer> l = adj_list.get(edge[0]);
            l.add(edge[1]);
            adj_list.set(edge[0], l);
        }

        TopologicalSort sort = new TopologicalSort();
        System.out.println(Arrays.toString(sort.topoSortDFS(adj_list, n)));
        System.out.println(Arrays.toString(sort.topoSortBFS(adj_list, n)));
    }

    int[] topoSortDFS(List<List<Integer>> adj, int n){
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[n+1];
        for(int i=1; i<=n; i++){
            if(vis[i]==0){
                findTopoSortDFS(i, adj, st, vis);
            }
        }

        int[] sorted = new int[n];
        int i = 0;
        while(!st.isEmpty()){
            sorted[i++] = st.pop();
        }

        return sorted;
    }

    void findTopoSortDFS(int node, List<List<Integer>> adj, Stack<Integer> st, int[] vis){
        vis[node] = 1;
        for(Integer it: adj.get(node)){
            if(vis[it]==0) findTopoSortDFS(it, adj, st, vis);
        }
        st.push(node);
    }

    int[] topoSortBFS(List<List<Integer>> adj, int n){
        int[] topo = new int[n];
        int[] indegree = new int[n+1];
        for(int i=1; i<=n; i++){
            for(Integer it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0) q.add(i);
        }
        String s = Arrays.toString(indegree);
        System.out.println(s);
        int ind = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[ind++] = node;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return topo;
    }
}
