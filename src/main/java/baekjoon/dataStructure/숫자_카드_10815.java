package baekjoon.dataStructure;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자_카드_10815 {

    //Set을 사용해서 카드를 갖고있는지 판단하는 메서드
    //Set에 카드를 넣고 Size가 커지면 카드를 소유하지 않는 것이고 Size가 그대로면 카드를 소유하는것
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

        //** 입력 시작
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
        //** 입력 끝

        int[] result = validateGetCard(NSet, MArray);

        //-- 출력
        for (int flag : result) {
            sb.append(flag).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
