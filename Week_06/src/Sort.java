import java.util.PriorityQueue;

/**
 * 排序算法模板
 */
public class Sort {

    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    /**
     * 插入排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int preIndex = i - 1;
            int current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(n^2) LeetCode会超时
     * 空间复杂度：O(1)
     */
    public int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 快速排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(nlogn)
     */
    public int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        //把end作为pivot
        //记录小于pivot的个数，也即pivot的位置
        int count = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]) {
                int temp = array[i];
                array[i] = array[count];
                array[count] = temp;
                count++;
            }
        }
        int temp = array[count];
        array[count] = array[end];
        array[end] = temp;
        return count;
    }

    /**
     * 归并排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     */
    public int[] mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }

    /**
     * 堆排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public int[] heapSort(int[] array) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int j : array) {
            heap.add(j);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.poll();
        }
        return array;
    }

    /**
     * 计数排序
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] countingSort(int[] array, int max) {
        int[] bucket = new int[max + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[array[i]]++;
        }
        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                array[j++] = i;
                bucket[i]--;
            }
        }
        return array;
    }
}
