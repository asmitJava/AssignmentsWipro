package com.dsa.day7;

import java.util.*;

class Graph2 {
    private int V; 
    private List<List<Integer>> adj;

    public Graph2(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); 
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

     
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
    }
}

public class Assignment3D8 {
    public static void main(String[] args) {
       
        int V = 6;
        Graph2 graph = new Graph2(V);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        int startNode = 0;
        System.out.println("DFS Traversal starting from node " + startNode + ":");
        graph.DFS(startNode);
    }
}