package com.dsa.day7;

import java.util.*;

class Graph {
	private int V;
	private List<List<Integer>> adj;

	public Graph(int V) {
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

	public void BFS(int start) {
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();

		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int neighbor : adj.get(node)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.offer(neighbor);
				}
			}
		}
	}




}

public class Assignment2D8 {
	public static void main(String[] args) {

		int V = 6;
		Graph graph = new Graph(V);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);

		int startNode = 0;
		System.out.println("BFS Traversal starting from node " + startNode + ":");
		graph.BFS(startNode);
	}
}