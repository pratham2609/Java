import java.util.*;
public class Fico {
    int[][] solution(int[][] matrix) {
        int n = matrix.length;
        int half = n / 2;

        for(int k = 0; k <= half; k++) {
            List<Integer> border = extractBorder(matrix, k);
            Collections.sort(border);
            placeBorder(matrix, border, k);
        }
        return matrix;
    }

    List<Integer> extractBorder(int[][] matrix, int k) {
        List<Integer> border = new ArrayList<>();
        int n = matrix.length;
        for(int i = k; i < n - k; i++) {
            border.add(matrix[k][i]);
        }

        for(int i = k + 1; i < n - k; i++) {
            border.add(matrix[i][n - k - 1]);
        }

        for(int i = n - k - 2; i >= k; i--) {
            border.add(matrix[n - k - 1][i]);
        }

        for(int i = n - k - 2; i > k; i--) {
            border.add(matrix[i][k]);
        }
        return border;
    }

    void placeBorder(int [][] matrix, List<Integer> border, int k ){
        int n = matrix.length;
        int index = 0;

        for(int i = k; i < n - k; i++) {
            matrix[k][i] = border.get(index++);
        }
        for(int i = k + 1; i < n - k; i++) {
            matrix[i][n - k - 1] = border.get(index++);
        }
        for(int i = n - k - 2; i >= k; i--) {
            matrix[n - k - 1][i] = border.get(index++);
        }
        for(int i = n - k - 2; i > k; i--) {
            matrix[i][k] = border.get(index++);
        }
    }
}
