import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static int decidePrecidence(char ch)
    {
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static String convertEquation(String s)
    {
        Stack<Character> stack = new Stack<>();
        int size=s.length();
        String newEquation="";

        for(int i = 0; i< size; i++)
        {
            if(Character.isDigit(s.charAt(i))==true)
                newEquation=newEquation+s.charAt(i);
            else {
                if(s.charAt(i)=='(')
                    stack.push(s.charAt(i));
                else if(s.charAt(i)==')')
                {
                    while(stack.peek()!='(')
                    {
                        newEquation=newEquation+stack.pop();
                    }
                    stack.pop();
                }
                else
                {
                    while(!stack.isEmpty() && decidePrecidence(s.charAt(i))<=decidePrecidence(stack.peek())) {
                        newEquation = newEquation + stack.peek();
                        stack.pop();
                    }
                    stack.push(s.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()){
            newEquation = newEquation + stack.pop();
        }
        return newEquation;
    }

    public static void main(String[] args) {

        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the infix equation;--");
        s=sc.nextLine();
        System.out.println("The postfix equation is :- "+ convertEquation(s));
    }
}