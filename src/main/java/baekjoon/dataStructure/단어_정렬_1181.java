package baekjoon.dataStructure;

    import java.io.*;
    import java.util.*;

    public class 단어_정렬_1181 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            Set<String> wordSet = new HashSet<>();

            //** 입력 시작
            int size = Integer.parseInt(br.readLine());
            for (int i = 0; i < size; i++) {
                wordSet.add(br.readLine());
            }
            //** 입력 끝

            //단어들을 사전순으로 정렬하고 길이 순으로 다시 정렬한다.
            List<String> wordList = new ArrayList<>(wordSet);
            wordList.sort(Comparator.naturalOrder());
            wordList.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

            for (String word : wordList) {
                sb.append(word).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
