import java.util.Scanner;

public class AVLTree_Insertion {
    class Node{
        int value,height;
        Node left,right;
        Node(int x){
            this.value=x;
            this.height=1;
            this.left=null;
            this.right=null;
        }
    }

    Node root;

    int height(Node x){
        if(x==null)
            return 0;
        return 1;
    }

    Node rightRotate(Node x){
        Node y = x.left;
        Node T1 = x.right;

        // Rotating
        y.right = x;
        x.left = T1;

        x.height=Math.max(height(x.left),height(x.right))+1;
        y.height=Math.max(height(x.left),height(x.right))+1;

        return y;
    }

    Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        //Rotating
        x.left = y;
        y.right = T2;

        y.height=Math.max(height(x.left),height(x.right))+1;
        x.height=Math.max(height(x.left),height(x.right))+1;

        return x;
    }

    int getBalance(Node node){
        if(node==null)
            return 0;
        return (height(node.left)-height(node.right));
    }

    Node insert(Node node,int key){
        if(node == null)
            return (new Node(key));

        if(key<node.value)
            node.left = insert(node.left,key);
        else if(key>node.value)
            node.right = insert(node.right,key);
        else
            return node;    // Duplicate elements are not allowed

        node.height = Math.max(height(node.left),height(node.right))+1;

        int balance = getBalance(node);

        if(balance>1 && key < node.left.value)  // LL
            return rightRotate(node);

        if(balance<-1 && key < node.right.value)  // RR
            return leftRotate(node);

        if(balance>1 && key > node.left.value ){  // LR
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if(balance<-1 && key > node.right.value){  // RL
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        AVLTree_Insertion tree = new AVLTree_Insertion();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Pre-Order traversal:- ");
        tree.preOrder(tree.root);
    }
}
