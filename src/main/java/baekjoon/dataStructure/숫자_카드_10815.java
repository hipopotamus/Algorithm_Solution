package baekjoon.dataStructure;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자_카드_10815 {

    private static int[] validateGetCard(Set<Integer> NSet, Integer[] MArray) {
        int[] result = new int[MArray.length];

        int setSize = NSet.size();
        for (int i = 0; i < MArray.length; i++) {
            Integer number = MArray[i];
            NSet.add(number);

            if (setSize != NSet.size()) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }

            setSize = NSet.size();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Set<Integer> NSet = new HashSet<>();

        int NSize = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NSize; i++) {
            Integer number = Integer.parseInt(st.nextToken());
            NSet.add(number);
        }

        int MSize = Integer.parseInt(br.readLine());
        Integer[] MArray = new Integer[MSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < MSize; i++) {
            int number = Integer.parseInt(st.nextToken());
            MArray[i] = number;
        }

        int[] result = validateGetCard(NSet, MArray);

        for (int flag : result) {
            sb.append(flag).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
