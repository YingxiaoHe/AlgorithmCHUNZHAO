package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素:https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class MajorityElement {

    /**
     * 时间负责度：O(n)
     * 空间复杂度：O(n);
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                max = Math.max(max, ++count);
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }
        if (max > nums.length / 2) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        } else {
            return -1;
        }
    }

    /**
     * 时间负责度：O(n)
     * 空间复杂度：O(n);
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
