package com.gfg;

import java.util.ArrayList;

public class NumberOfProvinces {
    private static void dfs(int node, int[] vis,
                            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) dfs(it, vis, adj);
        }
    }

    static int numberOfProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
        int cnt = 0;
        for (int i = 0; i < v; i++) {
            ls.add(new ArrayList<Integer>());
        }

//        to change adj matrix to list
        for (int i = 0; i < v; i++) {
            for(int j = 0; j < v; j++) {
                if(adj.get(i).get(j) == 1 && i != j) {
                    ls.get(i).add(j);
                    ls.get(j).add(i);
                }
            }
        }
        int[] vis = new int[v];
        for(int i = 0; i < v; i++) {
            if(vis[i] == 0) {
                cnt++;
                dfs(i, vis, ls);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

    }
}
