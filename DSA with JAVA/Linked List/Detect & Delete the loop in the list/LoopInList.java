import java.util.Scanner;

public class LoopInList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    void checkLoop()
    {
        Node slownode = head;
        Node fastnode = head;
        while(fastnode.next!=null)
        {
            slownode=slownode.next;
            fastnode=fastnode.next.next;
            if(slownode.data==fastnode.data) {
                System.out.println("\"There is a loop in the list:- \"");
                loopStartPoint(slownode);
                return;
            }
        }
        System.out.println("\"There is no loop in the list:- \"");
    }

    void loopStartPoint(Node slownode)
    {
        int index=0;
        Node temp = head;
        while(slownode!=temp)
        {
            temp=temp.next;
            slownode=slownode.next;
            index++;
        }
        System.out.println("start of loop is "+index);

        slownode.next=null;                     /* Here I am breaking the loop */
        System.out.println("Now The loop is broken...");
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;     /* node6.next = null; */

        LoopInList ll = new LoopInList();
        ll.checkLoop();
    }

}
