package com.gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDFS {
    public static void main(String[] args) {

    }
    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for(int adjNode: adj.get(node)) {
            if(vis[adjNode] == 0) {
                if(dfs(adjNode, node, adj, vis)) return true;
            }
            else if(adjNode != parent) return true;
        }
        return false;
    }
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[v];
        for (int i = 0; i < v; i++) {
            if(vis[i] == 0) {
                if(dfs(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }
}
