//https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void postOrder(Node root) {
        if(root !=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data +" ");
        }

    }

	public static Node insert(Node root, int data) {
