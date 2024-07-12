package com.gfg;

public class FloodFlow {
    //using dfs
    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol, int initColor) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == initColor
            && ans[nRow][nCol] != newColor) {
                dfs(nRow, nCol, ans, image, newColor, delRow, delCol, initColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        int[][] ans = image;
        int delRow[] = {-1, 0 ,+1, 0};
        int delCol[] = {0, +1, 0, -1};
        dfs(sr, sc, ans, image, newColor, delRow, delCol, initColor);
        return ans;
    }
    public static void main(String[] args) {

    }
}
