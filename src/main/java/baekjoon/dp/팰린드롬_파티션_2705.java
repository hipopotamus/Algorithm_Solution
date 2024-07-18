package baekjoon.dp;

import java.io.*;

public class 팰린드롬_파티션_2705 {

    public static void initPalindrome(int[] palindromeArr) {
        palindromeArr[1] = 1;
        palindromeArr[2] = 2;
        palindromeArr[3] = 2;

        for (int i = 4; i < palindromeArr.length; i++) {
            if (i % 2 == 0) {
                palindromeArr[i] = palindromeArr[i - 1] + palindromeArr[i / 2];
            } else {
                palindromeArr[i] = palindromeArr[i - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] palindromeArr = new int[1001];
        initPalindrome(palindromeArr);

        int caseSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseSize; i++) {
            int number = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(palindromeArr[number]));
            bw.newLine();
        }

        bw.flush();
    }
}
