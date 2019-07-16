public class MinHeap extends Heap {

    public MinHeap() {
        super();
    }

    public void heapify_up() {
        int index = size;
        int parent = parent(index);
        while(parent >= 0 && heap[parent] > heap[index]) {
            swap(parent,index);
            index = parent;
            parent = parent(index);
        }
    }

    public void heapify_down() {
        if(size == 0) {
            heap = new int[32];
        }
        else {
            int index = 0;
            while ((hasLeftChild(index)
                    && heap[index] > heap[leftChild(index)])
                    ||
                    (hasRightChild(index)
                            && heap[index] > heap[rightChild(index)])) {

                if(hasLeftChild(index)
                        && heap[index] > heap[leftChild(index)]
                        && heap[leftChild(index)] < heap[rightChild(index)]) {

                    swap(index,leftChild(index));
                    index = leftChild(index);

                }

                else if(hasRightChild(index)
                        && heap[index] > heap[rightChild(index)]
                        && heap[rightChild(index)] <= heap[leftChild(index)]) {

                    swap(index,rightChild(index));
                    index = rightChild(index);

                }
            }
        }
    }
}
