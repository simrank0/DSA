package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalsMST {
    static class Node {
        int u, v, w;

        Node() {
        }

        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "u=" + u +
                    ", v=" + v +
                    ", w=" + w +
                    '}';
        }
    }

    void kruskalAlgo(ArrayList<Node> adj, int N) {
        Collections.sort(adj, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });
        int[] parent = new int[N];
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int costMST = 0;
        ArrayList<Node> mst = new ArrayList<>();
        for (Node it : adj) {
            if (findPar(it.u, parent) != findPar(it.v, parent)) {
                costMST += it.w;
                mst.add(it);
                union(it.u, it.v, rank, parent);
            }
        }
        System.out.println("COST OF MST: " + costMST);
        System.out.println(mst);
    }

    int findPar(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findPar(parent[node], parent);
    }

    void union(int u, int v, int[] rank, int[] parent) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if (rank[v] < rank[u]) {
            parent[u] = v;
        } else if (rank[u] < rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();
        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 2));

        KruskalsMST obj = new KruskalsMST();
        obj.kruskalAlgo(adj, n);
    }
}
