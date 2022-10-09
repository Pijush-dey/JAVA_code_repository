import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackWithTwoQueues {

        static int num;
        static int count = 0;

        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();

        public static void push(int data) {
            if (count < num / 2) {
                queue1.add(data);
                count++;
            }
            else {
                queue2.add(data);
            }
        }

        public static int pop()
        {
            int n,i=0,size;
            if(queue2.isEmpty())
            {
                size=queue1.size();
                while(i<size-1)
                {
                    queue1.add(queue1.remove());
                    i++;
                }
                n = queue1.remove();
            }
            else
            {
                size=queue2.size();
                while(i<size-1)
                {
                    queue2.add(queue2.remove());
                    i++;
                }
                n = queue2.remove();
            }
            return n;
        }

        public static void main(String[] args) {
            int j=1;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter no. of elements:- ");
            num = sc.nextInt();
            System.out.println("Enter elements:- ");
            for (int i = 0; i < num; i++) {
                int ns = sc.nextInt();
                push(ns);
            }
            while(j<=num)
            {
                System.out.println(j+ "Pop is:- " + pop());
                j++;
            }
        }
    }
