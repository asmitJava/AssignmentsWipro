]package dsa.assignment;

import java.util.*;

public class KrushkalAlgo {

    
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

   
    static class Subset {
        int parent, rank;
    }

   
    static int find(Subset[] subsets, int i) {
        
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    
    static void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

       
        if (subsets[rootX].rank < subsets[rootY].rank)
            subsets[rootX].parent = rootY;
        else if (subsets[rootX].rank > subsets[rootY].rank)
            subsets[rootY].parent = rootX;
        else {
           
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

 
    static void kruskalMST(List<Edge> edges, int V) {
        
        edges.sort(Edge::compareTo);


        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        List<Edge> mst = new ArrayList<>(); 

        int e = 0; 

        while (mst.size() < V - 1) {
      
            Edge nextEdge = edges.get(e++);

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

        
            if (x != y) {
                mst.add(nextEdge);
                union(subsets, x, y);
            }
            // Else discard the edge
        }

        
        System.out.println("Edges of Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }

    public static void main(String[] args) {
        int V = 4; 
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        kruskalMST(edges, V);
    }
}