class Min_Heap {
    int[] arr;
    int heapSize, minSize;

    @SuppressWarnings("unused")
    Min_Heap(int minSize) {
        this.minSize = minSize;
        this.heapSize = 0;
        arr = new int[minSize];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int leftChild(int i) {
        return 2 * i + 1;
    }

    int rightChild(int i) {
        return 2 * i + 2;
    }

    void insert(int x) {
        if (heapSize == minSize) {
            System.out.println("Heap overflow");
            return;
        }

        int i = heapSize;
        arr[i] = x;
        heapSize++;

        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    @SuppressWarnings("unused")
    int getMin() {
        if (heapSize <= 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return arr[0];
    }

    @SuppressWarnings("unused")
    int currentSize() {
        return heapSize;
    }

    @SuppressWarnings("unused")
    void deleteMin() {
        if (heapSize <= 0) {
            System.out.println("Heap underflow");
            return;
        }

        if (heapSize == 1) {
            heapSize--;
            return;
        }

        arr[0] = arr[heapSize - 1];
        heapSize--;
        heapify(0);
    }

    void heapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;

        if (l < heapSize && arr[l] < arr[smallest]) smallest = l;
        if (r < heapSize && arr[r] < arr[smallest]) smallest = r;

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(smallest);
        }
    }

    public static void main(String[] args) {
        Min_Heap heap = new Min_Heap(10);

        heap.insert(50);
        heap.insert(30);
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(25);

        System.out.println("Min value: " + heap.getMin());
        System.out.println("Heap size: " + heap.currentSize());

        heap.deleteMin();
        System.out.println("After deleting min, new min value: " + heap.getMin());
        System.out.println("Heap size after delete: " + heap.currentSize());
    }
}
