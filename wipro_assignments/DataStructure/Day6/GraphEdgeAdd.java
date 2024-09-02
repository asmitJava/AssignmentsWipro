package com.dsa.day7;

import java.util.*;

class DirectedGraph {
	private int V;
	private List<List<Integer>> adj;

	public DirectedGraph(int V) {
		this.V = V;
		adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public void addEdge(int u, int v) {
		adj.get(u).add(v);
	}

	private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
		if (recStack[v])
			return true;

		if (visited[v])
			return false;

		visited[v] = true;
		recStack[v] = true;

		List<Integer> children = adj.get(v);
		for (Integer child : children) {
			if (isCyclicUtil(child, visited, recStack))
				return true;
		}

		recStack[v] = false; 
		return false;
	}

	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (isCyclicUtil(i, visited, recStack))
				return true;
		}

		return false;
	}
}

public class Assignment1D8 {
	public static void main(String[] args) {

		int V = 4;
		DirectedGraph graph = new DirectedGraph(V);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic()) {
			System.out.println("Graph has cycles. Edge cannot be added.");
		} else {
			int u = 1;
			int v = 3;
			graph.addEdge(u, v);
			System.out.println("Edge added from " + u + " to " + v + ".");
		}
	}
}