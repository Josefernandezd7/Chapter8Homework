import java.util.Arrays;

public class GenericSorting {
    
    public static <T extends Comparable<? super T>> void selectionSort(T[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j].compareTo(A[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = temp;
        }
    }
    public static <T extends Comparable<? super T>> void insertionSort(T[] A) {
        for (int i = 1; i < A.length; i++) {
            T key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j].compareTo(key) > 0) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }
    public static <T extends Comparable<? super T>> void bubbleSort(T[] A) {
        boolean swapped;
        for (int i = 0; i < A.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j].compareTo(A[j + 1]) > 0) {
                    T temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] A) {
        int n = A.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            T temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapify(A, i, 0);
        }
    }

    private static <T extends Comparable<? super T>> void heapify(T[] A, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && A[left].compareTo(A[largest]) > 0) {
            largest = left;
        }

        if (right < n && A[right].compareTo(A[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            heapify(A, n, largest);
        }
    }
    public static <T extends Comparable<? super T>> void mergeSort(T[] A) {
        if (A.length > 1) {
            int mid = A.length / 2;
            T[] left = Arrays.copyOfRange(A, 0, mid);
            T[] right = Arrays.copyOfRange(A, mid, A.length);

            mergeSort(left);
            mergeSort(right);

            merge(A, left, right);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] A, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
             }
        }

        while (i < left.length) {
            A[k++] = left[i++];
         }

        while (j < right.length) {
            A[k++] = right[j++];
        }
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] A, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(A, low, high);
            quickSort(A, low, partitionIndex - 1);
            quickSort(A, partitionIndex + 1, high);
           }
    }

    private static <T extends Comparable<? super T>> int partition(T[] A, int low, int high) {
         T pivot = A[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (A[j].compareTo(pivot) <= 0) {
                i++;
                T temp = A[i];
                A[i] = A[j];
                A[j] = temp;
              }
         }

          T temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        String[] arrayToSort = {"banana", "apple", "orange", "grape", "pineapple"};

        System.out.println("Original Array: " + Arrays.toString(arrayToSort));


        String[] selectionSorted = Arrays.copyOf(arrayToSort, arrayToSort.length);
        selectionSort(selectionSorted);
        System.out.println("Selection Sort: " + Arrays.toString(selectionSorted));

         String[] insertionSorted = Arrays.copyOf(arrayToSort, arrayToSort.length);
        insertionSort(insertionSorted);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSorted));

        String[] bubbleSorted = Arrays.copyOf(arrayToSort, arrayToSort.length);
        bubbleSort(bubbleSorted);
         System.out.println("Bubble Sort: " + Arrays.toString(bubbleSorted));

        String[] heapSorted = Arrays.copyOf(arrayToSort, arrayToSort.length);
         heapSort(heapSorted);
        System.out.println("Heap Sort: " + Arrays.toString(heapSorted));

        String[] mergeSorted = Arrays.copyOf(arrayToSort, arrayToSort.length);
        mergeSort(mergeSorted);
         System.out.println("Merge Sort: " + Arrays.toString(mergeSorted));

        String[] quickSorted = Arrays.copyOf(arrayToSort, arrayToSort.length);
        quickSort(quickSorted);
        System.out.println("Quick Sort: " + Arrays.toString(quickSorted));

    }
}