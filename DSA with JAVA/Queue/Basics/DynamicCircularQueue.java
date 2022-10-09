import java.util.Scanner;

/* For Circular Queue we have to use 4 variables (front, end, size, capacity ).

   By using Circular Queue, if there are any free slots at the beginning, the
   rear pointer can easily go to its next free slot. */

public class DynamicCircularQueue {

    int[] arr;
    static int front=-1;
    static int end=-1;
    int cap;
    static int size;

    DynamicCircularQueue(int capacity)
    {
        this.cap=capacity;
        this.arr = new int[capacity];
    }
    public void enqueue(int data)throws Exception
    {
        try{
            int i,j=0;

            if(front==-1)
                front=0;

            if(size>=cap)
            {
//                System.out.println("The queue is full!");
                int newcap = cap * 2;
                int[] newarr = new int[newcap];
                for(i = front; i!=end; i=(i+1)%cap)
                {
                    newarr[j++]= arr[i];
                }
                newarr[j]= arr[i%cap];

                arr=newarr;
                front=0;
                end=cap-1;
                cap=newcap;

                end=(end+1)%cap;
                arr[end]=data;
                size++;
            }
            else {
                end=(end+1)%cap;
                arr[end]=data;
                size++;
            }
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
                front = (front+1)%cap;
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
            int i;

            if (size==0) {     /*Check whether the array has elements or not */
                System.out.println("The queue is empty: underflow");
            }
            else{
                System.out.println("Elements are--");
                for (i = front; i != end; i=(i+1)%cap) {
                    System.out.println(arr[i]);
                }
                System.out.println(arr[i]);

                System.out.println("Total number of elements " + size);
            }
        }
        catch(Exception as){
            System.out.println("Exception occured..");
        }
    }
    public void point()
    {
        System.out.println("The \" FRONT \" pont is:"+front);
        System.out.println("The \" END \" pont is:"+end);
    }

    public static void main(String[] args) throws Exception {
        int choice,capacity,data,flag=1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity of Queue:- ");
        capacity = sc.nextInt();
        DynamicCircularQueue com = new DynamicCircularQueue(capacity);
        while(flag==1) {
            System.out.println("1.Add element");
            System.out.println("2.Delete element");
            System.out.println("3.Display the Queue");
            System.out.println("4.Find the \" FRONT \" & \" END \" point:- ");
            System.out.println("5.Exit");
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
                    com.point();
                    break;
                case 5:
                    flag = 0;
                    break;
                default:
                    System.out.println("Enter correct choice....");
            }
        }
    }
}