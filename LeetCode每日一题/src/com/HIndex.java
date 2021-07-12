package com;

/**
 * 275. H 指数 II:https://leetcode-cn.com/problems/h-index-ii/
 */
public class HIndex {

    /**
     * 二分法
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int length = citations.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = right + left >> 1;
            if (citations[mid] >= length - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return citations[right] >= length - right ? length - right : 0;
    }
}
