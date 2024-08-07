package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class N과_M_2_15650 {
    public static class Node {
        int number;
        boolean check = false;

        public Node(int number) {
            this.number = number;
        }
    }

    public static void combination(Node[] nodeArr, String currentPermutation, StringBuilder sb, int n, int depth, int index) {
        if (depth == n) {
            sb.append(currentPermutation).append("\n");
            return;
        }

        for (int i = index; i < nodeArr.length; i++) {
            Node currentNode = nodeArr[i];

            if (currentNode.check) {
                continue;
            }

            String savedString = currentPermutation + currentNode.number + " ";

            currentNode.check = true;
            combination(nodeArr, savedString, sb, n, depth + 1, i + 1);
            currentNode.check = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Node[] nodeArr = new Node[size + 1];

        for (int i = 1; i <= size; i++) {
            nodeArr[i] = new Node(i);
        }

        combination(nodeArr, "", sb, n, 0, 1);

        bw.write(sb.toString());
        bw.flush();
    }
}
