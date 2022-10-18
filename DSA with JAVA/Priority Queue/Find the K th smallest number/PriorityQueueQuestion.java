import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueQuestion {
    public static void main(String[] args) {
        int pos;
        int arr[] = {3,5,11,35,90,4,1,2};

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());   // Setting the priority queue as MAX HEAP
        Scanner sc = new Scanner(System.in);

        System.out.println("Find the K th smallest number ");
        System.out.print("Enter the position of the number: ");
        pos = sc.nextInt();

        for(int i=0;i<pos;i++)
        {
            queue.add(arr[i]);
        }
        for(int i=pos;i<arr.length;i++)
        {
            if(queue.peek()>arr[i])
            {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        System.out.println("The "+pos+"th smallest element is "+queue.peek());
    }
}
