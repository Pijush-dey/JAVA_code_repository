import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueImplementation {
    public static void main(String[] args) {
        int num;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());   // Setting the priority queue as MIN HEAP
        queue.add(65);
        queue.add(876);
        queue.add(1);
        queue.add(68);
        queue.add(500);
        queue.add(5000);
        queue.add(270);

        System.out.println("Setting all the numbers in ascending order");
        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            queue.poll();
        }
    }
}
