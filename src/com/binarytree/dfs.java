package com.binarytree;

import java.util.*;

public class dfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> l = new ArrayList<>();
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                l.add(sc.nextInt());
            }
            adj.add(l);
        }

        System.out.print(adj);
        System.out.println(" \n ");
        dfs(adj);
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!vis[i]) {
                dfs_util(i, adj, vis);
            }
        }
    }

    static void dfs_util(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[u] = true;
        System.out.print(u + " ");
        for (int num : adj.get(u)) {
            if (!vis[num]) {
                dfs_util(num, adj, vis);
            }
        }
    }
}

