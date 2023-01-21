package codingtest.showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int leftSum = 0;
        int rightSum = 0;
        int leftMax = 0;
        int rightMax = 0;

        int[] totemArr = new int[size];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            totemArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int totem : totemArr) {
            if (totem == 1) {
                leftSum += 1;
                rightSum -= 1;
            }
            if (totem == 2) {
                leftSum -= 1;
                rightSum += 1;
            }

            leftMax = Math.max(leftMax, leftSum);
            rightMax = Math.max(rightMax, rightSum);

            if (leftSum < 0) {
                leftSum = 0;
            }
            if (rightSum < 0) {
                rightSum = 0;
            }
        }

        int result = Math.max(rightMax, leftMax);
        result = Math.max(result, 1);

        System.out.println(result);
    }
}
