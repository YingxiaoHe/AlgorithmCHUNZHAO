import java.util.Stack;

public class Trap {

    /**
     * 按行求
     * 时间复杂度：O(n * m)
     * 空间复杂度：O(1)
     */
    public int trap(int[] height) {
        int sum = 0;
        int max = getMaxHeight(height);
        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int sumTemp = 0;
            for (int j : height) {
                if (isStart && j < i) {
                    sumTemp++;
                }
                if (j >= i) {
                    sum += sumTemp;
                    sumTemp = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private int getMaxHeight(int[] height) {
        int max = 0;
        for (int h : height) {
            max = Math.max(h, max);
        }
        return max;
    }

    /**
     * 按列求
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int trap2(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 用栈求
     */
    public int trap3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}
