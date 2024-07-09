package com.gfg;
import java.util.*;
public class BFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        ArrayList <Integer> bfs = new ArrayList<>();
        Queue <Integer> q = new LinkedList<>();

        vis[0] = true;
        q.add(0);

        while(!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it: adj.get(node)) {
                if(vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}
