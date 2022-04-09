package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuAlgo {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);

        KosarajuAlgo obj = new KosarajuAlgo();
        obj.kosaRaju(adj, n);
    }

    void kosaRaju(ArrayList<ArrayList<Integer>> adj, int N) {
        int vis[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) if (vis[i] == 0) dfs(i, stack, adj, vis);
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            vis[i] = 0;
            for (Integer it : adj.get(i))
                transpose.get(it).add(i);
        }

        while (!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();
            if (vis[node] == 0) {
                System.out.print("SCC: ");
                revDFS(node, transpose, vis);
                System.out.println();
            }
        }
    }

    void revDFS(int node, ArrayList<ArrayList<Integer>> transpose, int[] vis) {
        vis[node] = 1;
        System.out.print(node + " ");
        for(Integer it: transpose.get(node))
            if(vis[it]==0)
                revDFS(it, transpose, vis);
    }

    void dfs(int node, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for (Integer it : adj.get(node))
            if (vis[it] == 0) dfs(it, stack, adj, vis);
        stack.push(node);
    }
}
