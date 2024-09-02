package com.dsa.day7;

public class Assignment3D7 {
    private int[] heap;
    private int size;

    public Assignment3D7(int capacity) {
        heap = new int[capacity + 1];
        size = 0;
    }

    public void insert(int element) {
        if (size == heap.length - 1) {
            throw new RuntimeException("Heap is full");
        }

        heap[++size] = element;
        int index = size;
        while (index > 1 && heap[index / 2] > heap[index]) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    public int deleteMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }

        int min = heap[1];
        heap[1] = heap[size--];
        heapifyDown(1);
        return min;
    }

    public int getMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[1];
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index;
        int right = 2 * index + 1;

        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest!= index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        Assignment3D7 heap = new Assignment3D7(10);

        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);

        System.out.println("Min element: " + heap.getMin()); 

        heap.deleteMin();
        System.out.println("Min element: " + heap.getMin());

        heap.insert(0);
        System.out.println("Min element: " + heap.getMin()); 
    }
}