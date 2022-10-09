import java.util.Scanner;

/* For Circular Queue we have to use 3 variables (front, end, size, capacity )*/
public class DynamicQueue {

    static int[] arr;
    static int cap;
    static int front=-1;
    static int end=-1;
    static int size = 0;

    DynamicQueue(int capacity)
    {
        this.cap=capacity;
        this.arr = new int[cap];
    }
    public void enqueue(int data)throws Exception
    {
        try{
                if(front==-1)
                    front = 0;

                if(size==cap)
                {
                    cap = cap<<1;
                    int[] newarr = new int[cap];
                    for(int i = front; i<= end; i++)
                    {
                        newarr[i]= arr[i];
                    }
                    arr=newarr;
                }
                arr[++end]=data;
                size++;
        }
        catch(Exception as) {
        System.out.println("Exception occurred...");
        }
    }

    public void dequeue()throws Exception
    {
        try {
            if (size==0) {
                System.out.println("The queue is EMPTY: Underflow");
            }
            else {
                System.out.println("deleted element is " + arr[front]);
                arr[front] = Integer.MIN_VALUE;
                front++;
                size--;
            }
        }
        catch(Exception as) {
            System.out.println("Exception occured...");
        }
    }

    public void display()throws Exception
    {
        try {
            if (size!=0) {     /* Check whether the array is EMPTY or not */
                System.out.println("Elements are--");
                for (int i = end; i >= front; i--) {
                    System.out.println(arr[i]);
                }
                System.out.println("Total number of elements " + size);
            }
            else
                System.out.println("The queue is empty: underflow");
        }
        catch(Exception as){
            System.out.println("Exception occured..");
        }
    }

    public static void main(String[] args) throws Exception {
        int choice,capacity,data,flag=1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity of Queue:- ");
        capacity = sc.nextInt();
        DynamicQueue com = new DynamicQueue(capacity);
        while(flag==1) {
            System.out.println("1.Add element");
            System.out.println("2.Delete element");
            System.out.println("3.Display the Queue");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("Enter the number to be inserted:- ");
                    data=sc.nextInt();
                    com.enqueue(data);
                    break;
                case 2:
                    com.dequeue();
                    break;
                case 3:
                    com.display();
                    break;
                case 4:
                    flag = 0;
                    break;
                default:
                    System.out.println("Enter correct choice....");
            }
        }
    }
}
