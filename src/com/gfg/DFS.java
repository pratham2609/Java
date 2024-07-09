package com.gfg;
import java.util.*;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        ArrayList <Integer> dfs = new ArrayList<>();

        vis[0] = true;

        dfs(0, vis, adj, dfs);
        return dfs;
    }

    public static void dfs(int node, boolean[] vis,
                           ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);
        for(Integer it: adj.get(node)) {
            if(vis[it] == false) dfs(it, vis, adj, ls);
        }
    }
}
