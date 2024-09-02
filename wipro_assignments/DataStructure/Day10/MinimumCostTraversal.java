package dsa.assignment;

import java.util.Arrays;

public class MinimumCostTraversal {

    public static int findMinCost(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][1] = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int lastCity = 0; lastCity < n; lastCity++) {
                if ((mask & (1 << lastCity)) != 0) {
                    for (int nextCity = 0; nextCity < n; nextCity++) {
                        if (lastCity != nextCity && (mask & (1 << nextCity)) == 0) {
                            int newMask = mask | (1 << nextCity);
                            dp[nextCity][newMask] = Math.min(dp[nextCity][newMask], dp[lastCity][mask] + graph[lastCity][nextCity]);
                        }
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int lastCity = 1; lastCity < n; lastCity++) {
            minCost = Math.min(minCost, dp[lastCity][(1 << n) - 1] + graph[lastCity][0]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int minCost = findMinCost(graph);
        System.out.println("Minimum cost to visit all cities and return to the starting city: " + minCost);
    }
}