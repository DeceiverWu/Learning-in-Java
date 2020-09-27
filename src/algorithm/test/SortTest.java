package algorithm.test;

import java.util.Arrays;

/**
 *
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = new int[] {21, 4, 6, 44, 9, 1, 5, 29, 88, -1, -42};
        //bubbleSort(arr);
        optBuubleSort(arr);
        //insertSort(arr);
        //selectSort(arr);
        //quickSort(arr);
        //shellSort(arr);
        //mergeSort(arr);
        //heapSort(arr);
        //basicSort(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public  static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
        printArr(arr);
    }

    public static void optBuubleSort(int[] arr) {
        int len = arr.length;
        boolean flag = true;
        for (int i = 0; i < len - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
        }
        printArr(arr);
    }

    public static void insertSort(int[] arr) {
        //int len = arr.length;
        //for (int i = 1; i < len; i++) {
        //    int key = arr[i];
        //    int j = 0;
        //    for (j = i; j > 0 && arr[j-1] > key; j--) {
        //        arr[j] = arr[j-1];
        //    }
        //    arr[j] = key;
        //}
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = 0;
            for (j = i; j > 0 && arr[j-1] > key; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = key;
        }
        printArr(arr);
    }

    public static void selectSort(int[] arr) {
        //int len = arr.length;
        //for (int i = 0; i < len - 1; i++) {
        //    int k = i;
        //    for (int j = i + 1; j < len; j++) {
        //        if (arr[k] > arr[j])
        //            k = j;
        //    }
        //    if (k != i) {
        //        swap(arr, i, k);
        //    }
        //}
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int k = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            if (k != i) {
                swap(arr, k, i);
            }
        }
        printArr(arr);
    }

    public static void quickSort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
        printArr(arr);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, low + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int key = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= key)
                high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= key)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }

    public static void shellSort(int[] arr) {
        int len = arr.length;
        for (int incre = len / 2; incre > 0; incre /= 2) {
            for (int i = incre; i < len; i++) {
                int j = 0;
                int key = arr[i];
                for (j = i; j >= incre && arr[j - incre] > key; j -= incre) {
                    arr[j] = arr[j - incre];
                }
                arr[j] = key;
            }
        }
        printArr(arr);
    }

    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] tmp = new int[len + 1];
        sort(arr, 0, len - 1, tmp);
        printArr(arr);
    }

    public static void sort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) >> 1;
            sort(arr, low, mid, tmp);
            sort(arr, mid + 1, high, tmp);
            merge(arr, low, mid + 1, high, tmp);
        }
    }

    public static void merge(int[] arr, int begin, int mid, int end, int[] tmp) {
        int beginEnd = mid - 1;
        int index = begin;
        int counts = end - begin + 1;

        while (begin <= beginEnd && mid <= end) {
            if (arr[begin] <= arr[mid])
                tmp[index++] = arr[begin++];
            else
                tmp[index++] = arr[mid++];
        }
        while (begin <= beginEnd) tmp[index++] = arr[begin++];
        while (mid <= end) tmp[index++] = arr[mid++];

        while (counts > 0) {
            arr[end] = tmp[end];
            counts--;
            end--;
        }
    }

    public static void heapSort(int[] arr) {
        //int len = arr.length;
        //for (int i = len / 2 - 1; i >= 0; i--) {
        //    adjHeap(arr, i, len);
        //}
        //for (int i = len - 1; i >= 0; i--) {
        //    swap(arr, 0, i);
        //    adjHeap(arr, 0, i);
        //}
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjHeap(arr, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjHeap(arr, 0, i);
        }
        printArr(arr);
    }

    public static void adjHeap(int[] arr, int k, int len) {
        //int key = arr[k];
        //for (int i = k * 2; i < len; i = 2 * i) {
        //    if ((i + 1) < len && arr[i + 1] > arr[i]) {
        //        i++;
        //    }
        //    if (arr[i] > key) {
        //        arr[k] = arr[i];
        //        k = i;
        //    } else {
        //        break;
        //    }
        //}
        //arr[k] = key;
        int key = arr[k];
        for (int i = 2 * k; i < len; i = 2 * i) {
            if ((i + 1) < len && arr[i+1] > arr[i]) {
                i++;
            }
            if (arr[i] > key) {
                arr[k] = arr[i];
                k = i;
            } else {
                break;
            }
        }
        arr[k] = key;
    }

    public static void basicSort(int[] arr) {
        int len = arr.length;
        int[] bucket = new int[len];

        for (int i = 0; i < len; i++) {
            bucket[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
        printArr(arr);
    }
}
