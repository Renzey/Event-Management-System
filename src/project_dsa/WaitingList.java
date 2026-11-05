package project_dsa;


public class WaitingList {

    private Attendee[] heap = new Attendee[16];
    private int size = 0;
    private long counter = 0; 
    private boolean before(Attendee a, Attendee b) {
        if (a.getPriorityRank() != b.getPriorityRank()) {
            return a.getPriorityRank() < b.getPriorityRank();
        }
        return a.getArrival() < b.getArrival();
    }

    public void enqueue(Attendee a) {
        if (size == heap.length) {
            Attendee[] bigger = new Attendee[heap.length * 2];
            System.arraycopy(heap, 0, bigger, 0, size);
            heap = bigger;
        }
        a.setArrival(counter++);
        heap[size] = a;
        siftUp(size);
        size++;
    }

   
    public Attendee dequeue() {
        if (size == 0) {
            return null;
        }
        Attendee top = heap[0];
        size--;
        heap[0] = heap[size];
        heap[size] = null;
        if (size > 0) {
            siftDown(0);
        }
        return top;
    }

    public Attendee peek() {
        return size == 0 ? null : heap[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

   
    public boolean removeById(int id) {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (heap[i].getId() == id) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return false;
        }
        Attendee[] old = heap;
        int oldSize = size;
        heap = new Attendee[16];
        size = 0;
        for (int i = 0; i < oldSize; i++) {
            if (i != idx) {
               
                insertKeepArrival(old[i]);
            }
        }
        return true;
    }

    private void insertKeepArrival(Attendee a) {
        if (size == heap.length) {
            Attendee[] bigger = new Attendee[heap.length * 2];
            System.arraycopy(heap, 0, bigger, 0, size);
            heap = bigger;
        }
        heap[size] = a;
        siftUp(size);
        size++;
    }

    
    public Attendee[] toSortedArray() {
        WaitingList copy = new WaitingList();
        for (int i = 0; i < size; i++) {
            copy.insertKeepArrival(heap[i]);
        }
        Attendee[] result = new Attendee[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = copy.dequeue();
        }
        return result;
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (before(heap[i], heap[parent])) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int best = i;
            if (left < size && before(heap[left], heap[best])) {
                best = left;
            }
            if (right < size && before(heap[right], heap[best])) {
                best = right;
            }
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
        }
    }

    private void swap(int a, int b) {
        Attendee t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }
}