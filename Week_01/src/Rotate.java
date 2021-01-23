public class Rotate {

    /**
     * 临时数组
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] numbers = new int[length];
        System.arraycopy(nums, 0, numbers, 0, length);
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = numbers[i];
        }
    }

    /**
     * 反转数组
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
    }
}
