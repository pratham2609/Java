package com.gfg;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void bfs(int row, int col, int[][] vis, char[][] grid) {
        // put vis of the element as 1
        vis[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!queue.isEmpty()) {
            int ro = queue.peek().first;
            int co = queue.peek().second;
            queue.remove();

            for(int delrow = -1; delrow <= 1; delrow++) {
                for(int delcol = -1; delcol <= 1; delcol++) {
                    int newRow = ro + delrow;
                    int newCol = co + delcol;
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                    && grid[newRow][newCol] == '1' && vis[newRow][newCol] == 0) {
                        vis[newRow][newCol] = 1;
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // check if the element is not visited and is land too
                if(vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

    }
}
