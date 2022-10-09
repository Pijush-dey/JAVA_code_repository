import java.util.Scanner;
import java.util.*;

public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> arr)
    {
        Stack<Integer> arr1= new Stack<>();
        while(!arr.isEmpty())
        {
            arr1.push(arr.remove());
        }

        while (!arr1.isEmpty())
        {
            arr.add(arr1.pop());
        }

        while (!arr.isEmpty())
        {
            System.out.println(arr.remove());
        }
    }

    public static void main(String[] args) {
        int num, element;
        Queue<Integer> arr = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the Queue");
        num= sc.nextInt();
        System.out.println("Enter the elements in the Queue");
        for(int i=0;i<num;i++)
        {
            element = sc.nextInt();
            arr.add(element);
        }
        System.out.println("The reversed Queue is :-");
        reverseQueue(arr);
    }
}
