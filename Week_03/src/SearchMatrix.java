/**
 * 搜索二维矩阵：https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchMatrix {

    /**
     * 按行的顺序递归查找
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return find(matrix, 0, target);
    }

    private boolean find(int[][] matrix, int row, int target) {
        if (row >= matrix.length) {
            return false;
        }
        int len = matrix[row].length;
        if (matrix[row][0] > target) {
            return false;
        }
        if (matrix[row][len - 1] < target) {
            return find(matrix, row + 1, target);
        }
        for (int col = 0; col < len; col++) {
            if (matrix[row][col] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        int pivotIdx = 0, pivotElement = 0;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) {
                return true;
            } else {
                if (target > pivotElement) {
                    left = pivotIdx + 1;
                } else {
                    right = pivotIdx - 1;
                }
            }
        }
        return false;
    }
}
