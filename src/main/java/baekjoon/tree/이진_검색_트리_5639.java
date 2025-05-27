package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진_검색_트리_5639 {

    public static class Node {
        int number;
        Node left;
        Node right;

        public Node(int number) {
            this.number = number;
        }

        public void insert(int number) {
            if (number < this.number) {
                if (this.left == null) {
                    this.left = new Node(number);
                } else {
                    this.left.insert(number);
                }
            } else if (number > this.number) {
                if (this.right == null) {
                    this.right = new Node(number);
                } else {
                    this.right.insert(number);
                }
            }
        }
    }

    public static void printPostOrder(Node node) {
        if (node == null) {
            return;
        }

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.number);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;

        while (true) {
            input = br.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            root.insert(Integer.parseInt(input));
        }

        printPostOrder(root);
    }
}
