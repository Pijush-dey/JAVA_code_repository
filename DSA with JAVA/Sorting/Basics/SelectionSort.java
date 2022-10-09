public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {4, 1, 9, 5, 6, 10};
        int temp, min;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if(arr[j]<arr[min])              //if(arr[j]<arr[min])
                {
                    min=j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println("Sorted arry---");
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
