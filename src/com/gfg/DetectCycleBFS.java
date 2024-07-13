package com.gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBFS {
    static class Pair {
        int first;
        int second;
        Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }
    public static void main(String[] args) {

    }
    public boolean checkForSCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().first;
//            check for parent to not traverse back to parent
            int parent = q.peek().second;
            q.remove();
            for(int adjNode: adj.get(node)) {
                if(vis[adjNode] == false) {
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                } else if(parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        for(int i = 0; i < v; i++) {
            vis[i] = false;
        }
        for (int i = 0; i < v; i++) {
            if(vis[i] == false) {
                if(checkForSCycle(i, v, adj, vis)) return true;
            }
        }
        return false;
    }
}
