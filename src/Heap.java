class Heap {
    static void sort(int arr[], int N) {
//Build Heap
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
//Extract one by one element from Heap
        for (int i = N - 1; i > 0; i--) {
//Move current to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
//call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int N, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
//if left child is greater that root
        if (left < N && arr[left] > arr[largest])
            largest = left;
//if right child is greater than root
        if (right < N && arr[right] > arr[largest])
            largest = right;
//if root is not greater
        if (largest != i) {

            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
//Recursively heapify the remaining subtree
            heapify(arr, N, largest);
        }
    }

    static void printArray(int arr[], int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {11, 2, 8, 6, 5, 3, 12};
        int N = arr.length;
        sort(arr, N);
        printArray(arr, N);
    }
}