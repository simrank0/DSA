package graph;

public class DisjointSet {
    int[] parent = new int[100001];
    int[] rank = new int[100001];

    void makeSet() {
        for (int i = 1; i <= 100000; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int findPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findPar(parent[node]);
    }

    void union(int u, int v) {
        u = findPar(u);
        v = findPar(v);
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
        DisjointSet obj = new DisjointSet();
        obj.makeSet();
        int m = 4;
        int u = 2, v = 3;
//        obj.union(u, v);
        if(obj.findPar(u) == obj.findPar(v)) System.out.println("JOINED SET FOUND");
        else {
            System.out.println("THEY ARE DISJOINT SET");
            obj.union(u, v);
            System.out.println("IS JOINT SET NOW? " + (obj.findPar(u) == obj.findPar(v)));
        }
    }
}
