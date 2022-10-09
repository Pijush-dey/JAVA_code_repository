

import java.util.Arrays;

class Find_Missing_Number              //Write a Java program to find a missing number in an array.
{
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the index number you want to insert new element: ");
        //int x = sc.nextInt();
        //  System.out.println("Enter the new character: ");
        // char y = sc.next().charAt(0);
        //char[] a  = {'a','v','g','h','y'};
        int[] a = {7,5,2,4,3,6};
        int b = a.length;
        Arrays.sort(a);
        for(int i=0,j=1;i<b;i++,j++) {
            if (a[i] != j) {
                System.out.println("Missing number is: " + j);
                break;
            }
        }
    }
}
