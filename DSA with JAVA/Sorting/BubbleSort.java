
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {4, 1, 9, 5, 6, 10};
        int temp;
        for (int i = arr.length; i > 0; i--) {
            int flag = 0;
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] < arr[j + 1]) {      //if(arr[j]>arr[j+1])
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
                if(flag == 0) {
                    break;
                }
            }
        }
        System.out.println("Sorted arry---");
        for(int a:arr) {
            System.out.println(a);
        }
    }
}


