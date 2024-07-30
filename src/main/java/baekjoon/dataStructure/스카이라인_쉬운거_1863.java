package baekjoon.dataStructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인_쉬운거_1863 {

    public static int findBuilding(Stack<Integer> stack, int height) {
        int count = 0;

        while (!stack.isEmpty() && stack.peek() >= height) {
            if (stack.peek() > height) {
                stack.pop();
                count++;
            } else if (stack.peek() == height) {
                stack.pop();
            }
        }

        stack.push(height);

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Integer> heightStack = new Stack<>();

        int buildingCount = 0;
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            buildingCount += findBuilding(heightStack, row);
        }

        buildingCount += findBuilding(heightStack, 0);

        bw.write(String.valueOf(buildingCount));
        bw.flush();
    }
}
