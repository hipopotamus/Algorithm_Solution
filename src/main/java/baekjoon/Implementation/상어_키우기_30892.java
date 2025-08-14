package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 상어_키우기_30892 {

    public static long growShark(long[] sharkArray, int count, long sharkSize) {
        Stack<Long> feed = new Stack<>();

        for (int i = 0; i < sharkArray.length; i++) {
            if (count <= 0) {
                return sharkSize;
            }

            if (sharkSize > sharkArray[i]) {
                feed.push(sharkArray[i]);
            } else {
                while (sharkSize <= sharkArray[i]) {
                    if (feed.isEmpty()) {
                        return sharkSize;
                    }
                    if (count <= 0) {
                        return sharkSize;
                    }
                    sharkSize += feed.pop();
                    count--;
                }
                feed.push(sharkArray[i]);
            }
        }

        while (count > 0) {
            if (feed.isEmpty()) {
                return sharkSize;
            }
            sharkSize += feed.pop();
            count--;
        }

        return sharkSize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        long sharkSize = Long.parseLong(st.nextToken());

        long[] sharkArray = new long[size];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < sharkArray.length; i++) {
            sharkArray[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(sharkArray);

        long result = growShark(sharkArray, count, sharkSize);

        System.out.println(result);
    }
}
