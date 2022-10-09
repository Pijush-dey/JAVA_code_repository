import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class InterleavingNumbers {
    static int[] arr;
    static int cap;
    InterleavingNumbers(int cap)
    {
        this.cap=cap;
        this.arr=new int[cap];
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements:- ");
        cap=sc.nextInt();
        InterleavingNumbers user = new InterleavingNumbers(cap);
        System.out.println("Enter the array:-");
        for(int i=0;i<cap;i++)
        {
            int num= sc.nextInt();
            queue.add(num);
        }


        for(int i=0;i<cap/2;i++)
        {
            stack.push(queue.remove());
        }
        while(!stack.isEmpty())
        {
            queue.add(stack.pop());
        }
        for(int i=0;i<cap/2;i++)
        {
            queue.add(queue.remove());
        }
        for(int i=0;i<cap/2;i++)
        {
            stack.push(queue.remove());
        }
        while(!stack.isEmpty())
        {
            queue.add(stack.pop());
            queue.add(queue.remove());
        }

        System.out.println("The output is:-");
        while(!queue.isEmpty())
            System.out.print(queue.remove()+" ");
    }
}
