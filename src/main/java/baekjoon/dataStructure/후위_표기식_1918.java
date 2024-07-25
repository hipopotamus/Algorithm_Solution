package baekjoon.dataStructure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 후위_표기식_1918 {

    public static int priority(Character character) {
        switch (character) {
            case '+' :
            case '-' : return 1;
            case '*' :
            case '/' : return 2;
            default : return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        String formula = br.readLine();

        for (int i = 0; i < formula.length(); i++) {
            char character = formula.charAt(i);

            switch (character) {
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(character)) {
                        sb.append(stack.pop());
                    }
                    stack.push(character);
                    break;
                case ')' :
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                case '(' :
                    stack.push(character);
                    break;
                default:
                    sb.append(character);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
