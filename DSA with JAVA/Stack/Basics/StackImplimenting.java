import java.util.Stack;

public class StackImplimenting {
    public static void main(String[] args) {
       Stack<Integer> stack = new Stack<>();
       stack.push(34);
        stack.push(4);
        stack.push(64);
        stack.push(94);
        stack.push(84);

        System.out.println();
        System.out.println(stack.peek());

        System.out.println("Printing the Stack");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
