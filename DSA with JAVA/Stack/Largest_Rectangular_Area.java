import java.util.Scanner;
import java.util.Stack;

public class Largest_Rectangular_Area
{
    public static int[] nextSmaller(int[] arr,int num){
        Stack<Integer> stack = new Stack<>();
        int[] ns = new int[num];
        for(int i=num-1;i>=0;i--)
        {
            while(!stack.isEmpty()&& arr[stack.peek()]>=arr[i])
            {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ns[i] = -1;
            }
            else {
                ns[i] = stack.peek();
            }
            stack.push(i);
        }
        return ns;
    }

    public static int[] previousSmaller(int[] arr,int num){
        Stack<Integer> stack = new Stack<>();
        int[] ps = new int[num];
        for(int i =0;i<num;i++)
        {
            while(!stack.isEmpty()&& arr[stack.peek()]>=arr[i])
            {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ps[i] = -1;
            }
            else {
                ps[i] = stack.peek();
            }

            stack.push(i);
        }
        return ps;
    }

    public static int largestArea(int[] arr, int num)
    {
        int area = 0;
        int maxarea=0;
        int[] ps=previousSmaller(arr,num);
        int[] ns=nextSmaller(arr,num);
        for(int i =0;i<num;i++){
            area=(ns[i]-ps[i]-1)*arr[i];
            maxarea=(maxarea<area)?area:maxarea;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements will be entered in the array.");
        int num=sc.nextInt();
        int[] arr=new int[num];
        System.out.println("Enter the elements of the array:-");
        for(int i=0;i<num;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println();
        System.out.println("Largest possible Rectangle is:"+largestArea(arr,num));
    }
}
