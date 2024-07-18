package baekjoon.dp;

import java.io.*;

public class 칸토어_집합_4799 {

    public static String[] generateCantorSet(int n) {
        String[] cantorSet = new String[n + 1];
        cantorSet[0] = "-";

        for (int i = 1; i <= n; i++) {
            String blank = " ";
            String repeatedBlank = blank.repeat((int) Math.pow(3, i - 1));
            cantorSet[i] = cantorSet[i - 1] + repeatedBlank  + cantorSet[i - 1];
        }

        return cantorSet;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] cantorSet = generateCantorSet(12);

        String numberByString;
        while ((numberByString = br.readLine()) != null) {
            int exponentiation = Integer.parseInt(numberByString);
            bw.write(cantorSet[exponentiation]);
            bw.newLine();
            bw.flush();
        }
    }
}
