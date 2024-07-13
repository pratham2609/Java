package com.leetcode;
import java.util.*;
//https://leetcode.com/problems/count-the-number-of-complete-components/description/
public class CountCompleteComponents {
    static class Pair {
        int nodes, edges;
        Pair(int nodes, int edges) {
            this.nodes = nodes;
            this.edges = edges;
        }
    }
    public static int countCompleteComponents(int n, int[][] edges) {
            int[] vis = new int[n];
            List<Pair> list = new ArrayList<>();
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            for (int i = 0; i < n; i++) {
                if(vis[i] == 0) {
                    int[] c= dfs(i, adj, vis);
                    list.add(new Pair(c[0], c[1]));
                }
            }

            int cnt=0;
            for(Pair c: list){
                if(c.edges/2==c.nodes*(c.nodes-1)/2) cnt++;
            }

            return cnt;
    }

    public static int[] dfs(int curr, List<List<Integer>> adj, int[] vis){
            vis[curr]=1;
            int nodes=1; int edges=0;
            for(int nei:adj.get(curr)){
                edges++;
                if(vis[nei]==0){
                    int[] res=dfs(nei,adj,vis);
                    nodes+=res[0];
                    edges+=res[1];
                }
            }
            return new int[]{nodes,edges};
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1,2},{3,4}};
        int n = 6;

        System.out.println(countCompleteComponents(n, edges));

    }
}
