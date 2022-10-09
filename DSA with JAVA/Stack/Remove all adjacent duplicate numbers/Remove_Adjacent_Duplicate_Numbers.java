import java.util.Scanner;
import java.util.Stack;

public class Remove_Adjacent_Duplicate_Numbers
{
    public static void filteredArray(int[] arr,int num)
    {
        int i=0, top=-1;
        Stack<Integer> stack = new Stack<>();
        while(i<=num-1)
        {
          if(stack.isEmpty()||stack.peek()!=arr[i]) {
              stack.push(arr[i]);
              i++;
              top++;
          }
          else{
              if(i<num-1) {
                  while (stack.peek() == arr[i]) {
                      i++;
                  }
                  stack.pop();
                  stack.push(arr[i]);
                  i++;
              }
              else {
                  stack.pop();
                  top--;
                  break;
              }
          }

        }
        System.out.println("the output is");
        for(int j=0;j<=top;j++)
        {
            System.out.println(stack.pop());
        }
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
        filteredArray(arr,num);
    }
}
