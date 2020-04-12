import java.util.Comparator;
import java.util.PriorityQueue;

public class KLowestElements {

    /*comparator to create max heap*/
    static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }

    public static void main(String[] args) {
        //sample input
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};

        // heap size
        int k = 4;
        MaxHeapComparator maxHeapComparator = new MaxHeapComparator();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,
                maxHeapComparator);

        for (int value : input) {
            if (maxHeap.size() < k) {
                maxHeap.add(value);
            } else if (maxHeap.peek() > value) {
                maxHeap.remove();
                maxHeap.add(value);
            }
        }

        //print values
        for (int i : maxHeap) {
            System.out.print(i + " ");
        }
    }
}