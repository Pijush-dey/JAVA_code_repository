import javax.swing.*;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {4, 1, 9, 5, 6, 10};
        int temp;
        int length= arr.length;
        System.out.println("length:"+ length);
        for (int i=0; i<(length-1); i++) {
            for (int j=(i+1); j>0; j--) {
                if (arr[j] < arr[j-1])         // if (arr[j] > arr[j-1])
                {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println("Sorted arry---");
        for (int a : arr) {
            System.out.println(a);
        }
    }
}