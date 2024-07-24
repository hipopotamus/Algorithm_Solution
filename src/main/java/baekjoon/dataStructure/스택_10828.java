package baekjoon.dataStructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828 {

    public static void calculateStack(Stack<Integer> stack, String command, int number, StringBuilder sb) {
        switch (command) {
            case "push":
                stack.push(number);
                return;
            case "pop":
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                    return;
                }
                sb.append(stack.pop()).append("\n");
                return;
            case "size":
                sb.append(stack.size()).append("\n");
                return;
            case "empty":
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                return;
            case "top":
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                    return;
                }
                sb.append(stack.peek()).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int size = Integer.parseInt(br.readLine());


        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                calculateStack(stack, command, number, sb);
            } else {
                calculateStack(stack, command, 0, sb);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
