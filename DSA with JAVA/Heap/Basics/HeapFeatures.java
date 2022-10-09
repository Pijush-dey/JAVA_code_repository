import java.util.Scanner;
import java.lang.*;

    // --------------------------------THis is a MAX HEAP-------------------------------------
public class HeapFeatures {

    static int num;
    static int[] arr;

    void heapify1(int[] arr,int num, int i){            // Implementation of Heapify algorithm for "DELETE" & "SORTING" operation
        int left=0,right=0,largest=0;

        largest = i;
        left = 2*i+1;
        right = 2*i+2;

        if(left<num && arr[largest]<arr[left])
            largest=left;
        if(right<num && arr[largest]<arr[right])
            largest=right;
        if(largest!=i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify1(arr,num,largest);
        }
    }

    void heapify2(int[] arr, int i) {                 // Implementation of Heapify algorithm for "INSERT" operation
        int parent = (i/2);

        if(parent>=0 && arr[parent]<arr[i])
        {
            int temp = arr[parent];
            arr[parent]= arr[i];
            arr[i]=temp;

            heapify2(arr,parent);
        }
    }

    void insert(int[] arr, int x)                // Insertion operation in HEAP
    {
        num=num+1;

        arr[num-1]= x;

        heapify2(arr,num-1);
    }

    void delete(int[] arr)                 // Deletion operation of root element
    {
        int temp=arr[num-1];
        arr[0]=temp;
        num=num-1;

        heapify1(arr, num,0);
    }

    void display()              // Displaying Sorted array
    {
        for(int i=0; i<num; i++) {
            System.out.println(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int flag = 1, choice = 0;


        Scanner sc = new Scanner(System.in);
        HeapFeatures tree = new HeapFeatures();

        System.out.print("Enter the number, how many elements will be the HEAP- ");
        num=sc.nextInt();

        arr = new int[num*2];

        System.out.println("Enter the elements- ");
        for(int i=0;i<num;i++)
        {
            arr[i]=sc.nextInt();
        }

        for(int i=(num/2)-1; i>=0; i--){
            tree.heapify1(arr,num,i);                               // Build the array as a MAX HEAP
        }

        while (flag == 1) {
            System.out.println("1. Inserts the element in the HEAP");
            System.out.println("2. Delete the element from the HEAP");
            System.out.println("3. Display sorted array");
            System.out.println("4. EXIT");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the number, you want to insert- ");
                    int data1 = sc.nextInt();
                    tree.insert(arr,data1);
                    System.out.println("The number is successfully inserted.");
                    break;
                case 2:
                    tree.delete(arr);
                    System.out.println("The biggest number is successfully deleted.");
                    break;
                case 3:
                    tree.display();
                    break;
                case 4:
                    flag=0;
                    break;
                default:
                    System.out.println("Enter the right choice");
            }
        }
    }
}
