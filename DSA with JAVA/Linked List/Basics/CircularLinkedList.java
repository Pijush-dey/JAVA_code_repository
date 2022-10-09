import java.util.Scanner;

public class CircularLinkedList {
    int num;
    static int size = 0;
    Node head;
    Node tail;

    CircularLinkedList(int n) {
        this.num = n;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            Node next = null;
        }
    }

    void addFirst()          /* Insert at 1st */
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number, you want to insert- ");
        int data = sc.nextInt();
        System.out.println();
        Node node = new Node(data);
        if(size<num) {
            if (head == null) {
                head = node;
                tail = node;
                size++;
                return;
            }
            tail.next=node;
            node.next=head;
            head = node;
            size++;
        }
        else
            System.out.println("The linked list id full");
    }

    int removeFirst() {         /* Remove at 1st */
        int a=-1;
        if (size == 0 && head == null){
            System.out.println("The list is already empty, there is no NODE to delete");
            return a;
        }
        else{
            a=head.data;
            head=head.next;
            tail.next=head;
            size--;
        }
        return a;
    }

    void addLast()      /* Insert at last */
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number, you want to insert- ");
        int data = sc.nextInt();
        System.out.println();
        Node node = new Node(data);
        if(size<num) {
            if (head == null) {
                head = node;
                tail = node;
                size++;
                return;
            }

            tail.next=node;
            tail = node;
            tail.next = head;
            size++;
        }
        else
            System.out.println("The linked list is full");
    }

    int removeLast()                 /* Remove last element */
    {
        int a=-1;
        if (size == 0 && head == null){
            System.out.println("The list is already empty, there is no NODE to delete");
            return a;
        }
        else if(size == 1 && head.next==null) {
            a = head.data;
            head=null;
            size--;
        }
        else{
            a=tail.data;
            Node temp=head;
            while(temp.next!=tail)
            {
                temp=temp.next;
            }
            tail=temp;
            tail.next=head;
            size--;
        }
        return a;
    }

    void insertSpecificPosition()          /* Insert after a specific node */
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number, you want to insert- ");
        int data = sc.nextInt();
        System.out.println();
        System.out.print("Enter the value of specific node- ");
        int val = sc.nextInt();

        Node node = new Node(data);
        if(size<num) {
            if (head == null) {
                System.out.println("We cannot add the node at the specific position because the list is empty..");
                return;
            }

            Node temp = head;
            while(temp.data!=val)
            {
                temp=temp.next;
            }
            node.next=temp.next;
            temp.next=node;
            size++;
        }
        else
            System.out.println("The linked list is full");
    }

    void deleteSpecificPosition()             /* Delete a specific node */
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of specific node- ");
        int val = sc.nextInt();
        System.out.println();

        if(size==0 && head==null)
            System.out.println("There is no nodes in the list");
        else {
            Node node1 = head;
            Node node2 = head.next;
            while (node2.data != val) {
                node1 = node1.next;
                node2 = node2.next;
            }
            int a = node2.data;
            node1.next = node2.next;
            System.out.println("The node we delete, that contains the value of "+a);
            size--;
        }
    }

    void middlePoint(){             /* Finding the middlepoint of list */
        if(size==0 && head==null)
            System.out.println("There is no nodes in the list");
        else if(size==1 || size==2)
        {
            System.out.println("The middle point is: " + tail.data);
        }
        else {
            Node slownode = head;
            Node fastnode = head;
            while (fastnode!= null && fastnode != tail){
                slownode = slownode.next;
                fastnode = fastnode.next.next;
            }
            System.out.println("The middle point is: " + slownode.data);
        }
    }

    void print()                /* Print the whole list */
    {
        if(head==null)
        {
            System.out.println("There is no nodes in thelinked list...");
        }
        else {
            Node node = head;
            while (node != tail) {
                System.out.print(node.data + "-->");
                node = node.next;
            }
            System.out.print(node.data + "-->");
        }
    }

    public static void main(String[] args) {
        int choice = 0, flag = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements to be inserted:-");
        int n = sc.nextInt();

        CircularLinkedList ll = new CircularLinkedList(n);

        while (flag == 1) {
            System.out.println();
            System.out.println("1.Insert at 1st     2.Delete at 1st");
            System.out.println("3.Insert at last    4.Delete at last");
            System.out.println("5.Insert after a specific node");
            System.out.println("6.Delete a specific node");
            System.out.println("7.Print the current size");
            System.out.println("8.Find the middle node");
            System.out.println("9.Print the nodes");
            System.out.println("10.Exit");
            System.out.println();
            System.out.print("Enter your choice- ");
            choice = sc.nextInt();
            System.out.println();
            switch(choice){
                case 1:
                    ll.addFirst();
                    break;
                case 2:
                    System.out.println("The node we delete, that contains the value of "+ll.removeFirst());
                    break;
                case 3:
                    ll.addLast();
                    break;
                case 4:
                    System.out.println("The node we delete, that contains the value of "+ll.removeLast());
                    break;
                case 5:
                    ll.insertSpecificPosition();
                    break;
                case 6:
                    ll.deleteSpecificPosition();
                    break;
                case 7:
                    System.out.println("the current size is "+size);
                    break;
                case 8:
                    ll.middlePoint();
                    break;
                case 9:
                    ll.print();
                    break;
                case 10:
                    flag = 0;
                    break;
                default:
                    System.out.println("Please enter the correct number");
            }
        }
    }
}
