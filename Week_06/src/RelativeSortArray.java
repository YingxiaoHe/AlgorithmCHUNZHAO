/**
 * 1122. 数组的相对排序：https://leetcode-cn.com/problems/relative-sort-array/
 */
public class RelativeSortArray {

    /**
     * 计数排序
     * 因题中限定了数组长度和元素的范围，正好适合计数排序的条件
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int a1 : arr1) {
            count[a1]++;
        }
        int i = 0;
        for (int a2 : arr2) {
            while (count[a2] > 0) {
                arr1[i++] = a2;
                count[a2]--;
            }
        }
        for (int c = 0; c < count.length; c++) {
            while (count[c] > 0) {
                arr1[i++] = c;
                count[c]--;
            }
        }
        return arr1;
    }
}
