import java.util.*;

public class BinarySearchTreeFeatures {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    Node buildtree(Node root,int num) {
        if(root==null)
        {
            root=new Node(num);
            return root;
        }
        if(num<root.data)
            root.left=buildtree(root.left,num);
        else
            root.right=buildtree(root.right,num);

        return root;
    }

    void in_order(Node root){                // In-Order traversal.
        if(root==null)
        {
            return;
        }
        in_order(root.left);
        System.out.println(root.data+" ");
        in_order(root.right);
    }

    boolean search(Node root, int x)           // Searching  a node.
    {
        if(root==null)
        {
            return false;
        }

        if(root.data<x)
        {
            return search(root.right, x);
        }
        else if(root.data==x)
        {
            return true;
        }
        else
        {
            return search(root.left, x);
        }
    }

    Node inOrderSuccessor(Node root)       // Function called in the "delete" function
    {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }

    Node delete(Node root, int x)                // Delete a node.
    {
        if(root==null)
            return null;

        if(root.data<x)
            root.right=delete(root.right,x);
        else if(root.data>x)
            root.left=delete(root.left,x);
        else{
            if (root.left == null && root.right == null)     // Case no 1 - If the node has no child node.
                return null;
            else if (root.left == null)                      // Case no 2 -
                return root.right;                           // If the node has
            else if(root.right==null)                        // one chile node
                return root.left;
            else {                                           // Case no. 3 - If the node has 2 chile nodes.
                Node temp = inOrderSuccessor(root.right);
                root.data= temp.data;
                delete(root, temp.data);
            }
        }
        return root;
    }

    void range(Node root, int x, int y)                  // Found the nodes in between a range
    {
        if(root==null)
            return;

        if(root.data<=x)
            range(root.right,x,y);
        else if(root.data>=y)
            range(root.left,x,y);
        else if(root.data>=x && root.data<=y)
        {
            range(root.left,x,y);
            System.out.println(root.data+" ");
            range(root.right,x,y);
        }
    }

    void pathPrint(ArrayList<Integer> path)            // Function called in the "root2leaf" function
    {
        for(int i=0;i<path.size();i++)
        {
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }
    void root2leaf(Node root, ArrayList<Integer> path)             // Print all path from root to leaf
    {
        if(root==null)
            return;

        path.add(root.data);

        if(root.left==null && root.right==null)
            pathPrint(path);
        else {
            root2leaf(root.left, path);
            root2leaf(root.right, path);
        }

        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        int num, choice=0, flag=1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers will be inserted in the array:- ");
        num = sc.nextInt();

        int[] arr = new int[num];
        System.out.println("Enter the elements-- ");

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = null;
        BinarySearchTreeFeatures tree = new BinarySearchTreeFeatures();
        for (int i = 0; i < num; i++) {
            root = tree.buildtree(root, arr[i]);
        }

        while (flag == 1) {
            System.out.print("1. In-Order Traversal\t\t\t");        // In case of IN-ORDER traversal the tree always give a sorted array.
            System.out.println("2. Search a node");
            System.out.print("3. Delete a Node\t\t\t");
            System.out.println("4. Print in between a range");
            System.out.println("5. Path to leaf");
            System.out.println("6. Exit ");
            System.out.print("Enter your choice- ");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    tree.in_order(root);
                    break;
                case 2:
                    System.out.println("Enter the number you want to search");
                    int x=sc.nextInt();
                    if(tree.search(root,x))
                        System.out.println("The number is present in the Binary Search Tree");
                    else
                        System.out.println("The number is not present in the Binary Search Tree");
                    break;
                case 3:
                    System.out.println("Enter the number you want to search");
                    int data=sc.nextInt();
                    tree.delete(root,data);
                    System.out.println("The number is deleted successfully.");
                    break;
                case 4:
                    System.out.println("Enter the 1st number");
                    int data1=sc.nextInt();
                    System.out.println("Enter the last number");
                    int data2=sc.nextInt();
                    tree.range(root, data1, data2);
                    break;
                case 5:
                    System.out.println("Path to the leafs are:- ");
                    tree.root2leaf(root, new ArrayList<>());
                    break;
                case 6:
                    flag=0;
                    break;
                default:                                                                                                                                                                                                                                                                                          
                    System.out.println("choose correct number");
            }
        }
    }
}
