package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node>
{
    int v, w;
    Node() {}
    Node(int v, int w){
        this.v = v;
        this.w = w;
    }
    @Override
    public int compare(Node n1, Node n2){
        return n1.w - n2.w;
    }
}

public class PrimsMST {
    void primsAlgo(ArrayList<ArrayList<Node>> adj, int N){
        int[] key = new int[N];
        int[] parent = new int[N];

        Arrays.fill(key, Integer.MAX_VALUE);

        PriorityQueue<Node> pq= new PriorityQueue<>(N, new Node());
        key[0] = 0;
        parent[0] = -1;
        pq.add(new Node(0, key[0]));

        while (!pq.isEmpty()){
            int u = pq.poll().v;
            for (Node it : adj.get(u)) {
                if (it.w < key[it.v]) {
                    key[it.v] = it.w;
                    parent[it.v] = u;
                    pq.add(new Node(it.v, key[it.v]));
                }
            }
        }
        for(int i = 1; i < N; i++){
            System.out.println(parent[i] + " -> " + i);
        }
    }

    public static void main(String[] args)
    {
        int n = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        PrimsMST obj = new PrimsMST();
        obj.primsAlgo(adj, n);

    }
}
