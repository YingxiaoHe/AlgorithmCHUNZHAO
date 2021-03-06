学习笔记

    一个对排序总结非常好的网址：https://www.cnblogs.com/onepixel/p/7674659.html
    带图片的总结地址：https://shimo.im/docs/8cQtpVqYwwXjTrRH/
# 比较类排序
    通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
# 非比较类排序
    不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

# 1、选择排序
    每次找到最小值，然后放到待排序数组的起始位置。
```java
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
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }
}
```
# 2、插入排序
    从前到后逐步构建有序序列。对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
```java
public class Sort {
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
}
```
# 3、冒泡排序
    每次比较相邻的元素，如果逆序，则交换。相当于一个反向的选择排序，将数组从后往前（从大到小）整理好。
```java
public class Sort {
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
}
```
# 4、快速排序
    从数组中挑选出一个做为基准，将比基准小的放在它前面，比基准大的放在它后面。然后再对前后分区做相同操作。递归操作。先排序、再分区。
```java
public class Sort {
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
}
```
# 5、归并排序
    先将数组分成左右两个分区，然后对两个分区内部进行排序，再将两个分区与按顺序排序。递归操作。快速排序正好相反，归并排序是先分区、再排序。
```java
public class Sort {
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
}
```
# 6、堆排序
    利用堆的性质来进行排序
```java
public class Sort {
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
}
```
# 7、计数排序
    将每个元素出现的次数存入一个数组当中，数组下标即其元素的值。因元素要做为数组下标且数组的大小由其范围决定，所以计数排序必须规定数据的范围的整数。
```java
public class Sort {
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
```