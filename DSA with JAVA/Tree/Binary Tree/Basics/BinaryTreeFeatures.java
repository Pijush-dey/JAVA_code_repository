import java.util.*;
import java.util.Scanner;

public class BinaryTreeFeatures {

    static int diameter=0;
    static int value=0;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int[] arr) {         /* Method for creating TREE structure from array elements */
            idx++;
            if (arr[idx] == -1) {
                return null;
            }
            Node node = new Node(arr[idx]);
            node.left = buildTree(arr);
            node.right = buildTree(arr);

            return node;
        }

        public void pre_order(Node root)        /* For Pre-order traversal */ {
            if (root == null) {
                return;
            }
            System.out.println(root.data);
            pre_order(root.left);
            pre_order(root.right);
        }

        public void post_order(Node root)          /* For Post-order traversal */ {
            if (root == null) {
                return;
            }
            post_order(root.left);
            post_order(root.right);
            System.out.println(root.data);
        }

        public void in_order(Node root)             /* For In-order traversal */ {
            if (root == null) {
                return;
            }
            in_order(root.left);
            System.out.println(root.data);
            in_order(root.right);
        }

        public void level_order(Node root) {
            Queue<Node> q= new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node node = q.remove();
                if(node==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.println(node.data+" ");
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }
            }
        }

        public int count_nodes(Node root)
        {
            if (root == null) {
                return 0;
            }
            int left_side=count_nodes(root.left);
            int right_side=count_nodes(root.right);

            return left_side+right_side+1;
        }

        public int sum_nodes(Node root)
        {
            if (root == null) {
                return 0;
            }
            int left_side=count_nodes(root.left);
            int right_side=count_nodes(root.right);

            return left_side+right_side+root.data;
        }

        public int depth_tree(Node root)
        {
            if (root == null) {
                return 0;
            }
            int left_side=count_nodes(root.left);
            int right_side=count_nodes(root.right);

            return Math.max(left_side,right_side)+1;
        }

        public int diameter(Node root)          /* Calculate the diameter of the tree */
        {
            if (root == null) {
                return 0;
            }
            int left_side=count_nodes(root.left);
            int right_side=count_nodes(root.right);

            diameter=Math.max(diameter,left_side+right_side);

            return Math.max(left_side,right_side);
        }

        public Node lowest_common_ancestor(Node root,int n1, int n2){
            if(root==null){
                return null;
            }
            if(root.data==n1 || root.data==n2){
                return root;
            }

            Node left =lowest_common_ancestor(root.left, n1, n2);
            Node right =lowest_common_ancestor(root.right, n1, n2);

            if(left==null)
                return right;
            if(right==null)
                return left;

            return root;
        }

        public void max_value(Node root)        /* Find, which node has the highest value */
        {
            if (root == null) {
                return ;
            }
            max_value(root.left);
            max_value(root.right);

            value=Math.max(value,root.data);
        }
    }


    public static void main(String[] args) {
        int num, choice = 0,flag=1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers will be inserted in the array:- ");
        num = sc.nextInt();

        int[] arr = new int[num];
        System.out.println("Enter the elements-- ");

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();            //  Like  [ 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 ]
        }

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr);
        System.out.println("Root node in the tree is : "+root.data);

        while (flag == 1) {
            System.out.print("1. Pre-order Traversal\t\t\t");
            System.out.println("2. Post-Order Traversal");
            System.out.print("3. In-Order Traversal\t\t\t");
            System.out.print("4. Level order Traversal");
            System.out.println("5. Count of Nodes\t\t\t");
            System.out.println("6. Sum of nodes");
            System.out.print("7. Depth of tree\t\t\t");
            System.out.println("8. Diameter of tree");
            System.out.println("9. lowest common ancestor of tree");
            System.out.println("10. Find the maximum value in node");
            System.out.println("11. Exit ");
            System.out.print("Enter your choice- ");
            switch (choice) {
                case 1:
                    tree.pre_order(root);
                    break;
                case 2:
                    tree.post_order(root);
                    break;
                case 3:
                    tree.in_order(root);
                    break;
                case 4:
                    tree.level_order(root);    break;
                case 5:
                    System.out.println("Count of nodes "+tree.count_nodes(root));
                    break;
                case 6:
                    System.out.println("Sum of nodes "+tree.sum_nodes(root));
                    break;
                case 7:
                    System.out.println("Diameter of tree "+tree.depth_tree(root));
                    break;
                case 8:
                    tree.diameter(root);
                    System.out.println("The diameter of the tree will be:- "+diameter);
                    break;
                case 9:
                    tree.lowest_common_ancestor(root,6,9);
                    break;
                case 10:
                    tree.max_value(root);
                    System.out.println("The diameter of the tree will be:- "+value);
                    break;
                case 11:
                    flag=0;
                    break;
                default:
                    System.out.println("choose correct number");
            }
        }
    }
}