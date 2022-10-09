import java.util.Scanner;
import java.util.Stack;

public class PalindromeUsingStack
{
    public static boolean palindrome(String s)
    {
        int i=0;
        int size=s.length();
        Stack<Character> stack = new Stack<>();
        while(s.charAt(i)!='X')
        {
            stack.push(s.charAt(i));
            i++;
        }
        i++;
        while(i<size)
        {
            if(stack.pop()!=s.charAt(i))
            {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Sentence: ");
        s = sc.nextLine();
        System.out.println("The sentence is palindrome:- "+palindrome(s));
    }
}
