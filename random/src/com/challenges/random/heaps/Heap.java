package com.challenges.random.heaps;

import java.util.Arrays;

public abstract class Heap {

    int[] heap;
    int size;

    public Heap() {
        heap = new int[32];
        size = 0;
    }

    private void checkSize() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, (size * 2));
        }
    }

    public abstract void heapify_up();

    public abstract void heapify_down();

    public void insert(int val) {
        checkSize();
        heap[size] = val;
        heapify_up();
        size++;
    }

    public int pop() {
        int output = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify_down();
        return output;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean hasLeftChild(int index) {
        return (((2 * index) + 1) < size);
    }

    public boolean hasRightChild(int index) {
        return (((2 * index) + 2) < size);
    }

    public int parent(int index) {
        return (index / 2);
    }

    public int leftChild(int index) {
        if (hasLeftChild(index)) {
            return ((2 * index) + 1);
        }
        return -1;
    }

    public int rightChild(int index) {
        if (hasRightChild(index)) {
            return ((2 * index) + 2);
        }
        return -1;
    }

}
