import java.util.Scanner;
import java.util.Stack;

public class SymbolBalancingCheck {
    public static boolean checkBalancing(String s)
    {
        Stack <Character> stack = new Stack<Character>();
        int size = s.length();
        if(s==null||size==0)
        {
            return true;
        }
        for(int i=0;i<size;i++)
        {
            char ch = s.charAt(i);

            if(ch=='('||ch=='{'||ch=='[')
            {
                stack.push(ch);
            }
            else
            {
                switch(ch)
                {
                    case ']':
                        if(!s.isEmpty()&&stack.peek()=='[')
                            stack.pop();
                        else
                            return false;
                        break;
                    case '}':
                        if(!s.isEmpty()&&stack.peek()=='{')
                            stack.pop();
                        else
                            return false;
                        break;
                    case ')':
                        if(!s.isEmpty()&&stack.peek()=='(')
                            stack.pop();
                        else
                            return false;
                        break;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        String expression;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the infix equation:-");
        expression =sc.nextLine();
        System.out.println();
        System.out.println("The given expression is balanced:"+checkBalancing(expression));
    }
}
