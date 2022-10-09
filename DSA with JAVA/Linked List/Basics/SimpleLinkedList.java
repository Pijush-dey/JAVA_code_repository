import java.util.Scanner;

public class SimpleLinkedList {

     int num;
    static int size;
    Node head;

    SimpleLinkedList(int n)
    {
        this.num=n;
    }
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next = null;
        }
    }

    void addFirst()            /* Insert at 1st */
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number, you want to insert- ");
        int data = sc.nextInt();
        System.out.println();
        Node node = new Node(data);
        if(size<num) {
            if (head == null) {
                head = node;
                size++;
                return;
            }
            node.next = head;
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
                size++;
                return;
            }

            Node temp = head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=node;
            node.next=null;
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
            Node temp1 = head;
            Node temp2 = head.next;
            while(temp2.next!=null)
            {
                temp1=temp1.next;
                temp2=temp2.next;
            }
            a=temp2.data;
            temp1.next=null;
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

        Node node = new Node (data);
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
        }
    }

    void middlePoint(){             /* Finding the middlepoint of list */
        if(size==0 && head==null)
            System.out.println("There is no nodes in the list");
        else if(size==1)
        {
            System.out.println("The middle point is: " + head.data);
        }
        else if(size==2)
        {
            Node node = head.next;
            System.out.println("The middle point is: " + node.data);
        }
        else {
            try {
                Node slownode = head;
                Node fastnode = head;
                while (fastnode!= null && fastnode.next != null) {
                    slownode = slownode.next;
                    fastnode = fastnode.next.next;
                }
                System.out.println("The middle point is: " + slownode.data);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    void searchNode(){                  /* Searching node at a specific position */
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the position-number of the node from tail of the list- ");
        int pos = sc.nextInt();
        System.out.println();

        if (size == 0 && head == null)
            System.out.println("There is no nodes in the list");
        else {
            Node node1 = head;
            Node node2 = head;
            while(count<pos)
            {
                node2=node2.next;
                count++;
            }
            while(node2!=null)
            {
                node1=node1.next;
                node2=node2.next;
            }
            System.out.println("The value of specific location is "+node1.data);
        }
    }

    void print()                /* Print the whole list */
    {
        Node node = head;
        while(node!=null)
        {
            System.out.print(node.data+"-->");
            node=node.next;
        }
        System.out.println("NULL");
    }

    void reverse()
    {
        if (size == 0 && head == null) {
            System.out.println("There is no nodes in the list");
            return;
        }
        if((size == 1 && head.next == null)) {
            System.out.println("There is only one node in the whole list");
            return;
        }

        Node prevnode =head;
        Node currnode =head.next;
        while(currnode!=null)
        {
            Node nextnode = currnode.next;
            currnode.next = prevnode;

            prevnode=currnode;
            currnode=nextnode;
        }
        head.next=null;
        head=prevnode;

        System.out.println();
        System.out.println("The reversed list is reversed........");
    }

    public static void main(String[] args) {
        int choice=0,flag=1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements to be inserted:-");
        int n= sc.nextInt();

        SimpleLinkedList ll = new SimpleLinkedList(n);

        while(flag==1) {
            System.out.println();
            System.out.println("1.Insert at 1st     2.Delete at 1st");
            System.out.println("3.Insert at last    4.Delete at last");
            System.out.println("5.Insert after a specific node");
            System.out.println("6.Delete a specific node");
            System.out.println("7.Print the current size");
            System.out.println("8.Find the middle node");
            System.out.println("9.Find the nth node from the tail of the list");
            System.out.println("10.Print the nodes");
            System.out.println("11.Reverse the list");
            System.out.println("12.Exit");
            System.out.println();
            System.out.print("Enter your choice- ");
            choice = sc.nextInt();
            System.out.println();
            switch (choice) {
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
                    ll.searchNode();
                    break;
                case 10:
                    ll.print();
                    break;
                case 11:
                    ll.reverse();
                    break;
                case 12:
                    flag = 0;
                    break;
                default:
                    System.out.println("Please enter the correct number");
            }
        }
    }
}