import java.util.Scanner;
import java.util.Stack;

public class CalculatePostfixExpression {

    public static int simplifyExpression(String s)
    {
        Stack<Integer>stack = new Stack<Integer>();
        int size = s.length();

        for(int i=0;i<size;i++)
        {
            char ch = s.charAt(i);

            if(Character.isDigit(ch))
                stack.push(ch-'0');
            else
            {
                int op1=stack.pop();
                int op2=stack.pop();
                switch(ch){
                    case '+':
                        stack.push(op1+op2);
                        break;
                    case '-':
                        stack.push(op2-op1);
                        break;
                    case '*':
                        stack.push(op2*op1);
                        break;
                    case '/':
                        stack.push(op2/op1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the following expression:-");
        s = sc.nextLine();
        System.out.println();
        System.out.println("The output of the expression is:"+simplifyExpression(s));
    }
}
