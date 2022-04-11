package Graph;

import java.util.*;

public class DijkstrasAlgo {
    static class Node implements Comparator<Node> {

        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        Node() {
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.w - o2.w;
        }
    }

    void shortestPath(int s, List<List<Node>> adj, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new Node());
        pq.add(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for(Node it : adj.get(node.v)){
                if(dist[it.v]>dist[node.v]+it.w){
                    dist[it.v] = dist[node.v] + it.w;
                    pq.add(new Node(it.v, dist[it.v]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        List<List<Node>> adj_list = new ArrayList<>();
        int n = 5;
        for (int i = 0; i < n; i++) {
            adj_list.add(new ArrayList<>());
        }
        adj_list.get(0).add(new Node(1, 2));
        adj_list.get(1).add(new Node(0, 2));
        adj_list.get(1).add(new Node(2, 4));
        adj_list.get(2).add(new Node(1, 4));
        adj_list.get(0).add(new Node(3, 1));
        adj_list.get(3).add(new Node(0, 1));
        adj_list.get(3).add(new Node(2, 3));
        adj_list.get(2).add(new Node(3, 3));
        adj_list.get(1).add(new Node(4, 5));
        adj_list.get(4).add(new Node(1, 5));
        adj_list.get(2).add(new Node(4, 1));
        adj_list.get(4).add(new Node(2, 1));
        DijkstrasAlgo d = new DijkstrasAlgo();
        d.shortestPath(0, adj_list, n);
    }
}
