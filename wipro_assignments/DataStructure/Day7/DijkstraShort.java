package dsa.assignment;

import java.util.*;

public class DijkstraShort {


    static class Graph {
        private final int V; 
        private final List<List<Edge>> adj; 
      
        static class Edge {
            int target;
            int weight;

            Edge(int target, int weight) {
                this.target = target;
                this.weight = weight;
            }
        }

       
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; ++i)
                adj.add(new ArrayList<>());
        }

       
        void addEdge(int u, int v, int weight) {
            adj.get(u).add(new Edge(v, weight));
            adj.get(v).add(new Edge(u, weight)); 
        }

        
        void dijkstra(int src) {
            PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            int[] dist = new int[V]; 

            
            Arrays.fill(dist, Integer.MAX_VALUE);

            minHeap.add(new Edge(src, 0));
            dist[src] = 0;

            while (!minHeap.isEmpty()) {
                int u = minHeap.poll().target;

                
                for (Edge e : adj.get(u)) {
                    int v = e.target;
                    int weight = e.weight;

                   
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                     
                        dist[v] = dist[u] + weight;
                        minHeap.add(new Edge(v, dist[v]));
                    }
                }
            }

            
            System.out.println("Shortest distances from source node " + src + ":");
            for (int i = 0; i < V; ++i)
                System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; 
        int src = 0;

        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);

        graph.dijkstra(src);
    }
}