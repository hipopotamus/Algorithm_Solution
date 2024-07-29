package baekjoon.tree;

import java.io.*;
import java.util.*;

public class 완전_이진_트리_9934 {

    //inOrder로 트리를 탐색하는 메서드
    //노드를 탐색할 때, numberQueue에서 숫자를 빼고 깊이에 따라 depthList에 넣어준다
    public static void inOrder(Queue<Integer> numberQueue, List<Queue<Integer>> depthList, int depth, int maxDepth) {
        if (depth == maxDepth) {
            return;
        }

        inOrder(numberQueue, depthList, depth + 1, maxDepth);

        Integer number = numberQueue.poll();
        depthList.get(depth).add(number);

        inOrder(numberQueue, depthList, depth + 1, maxDepth);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> numberQueue = new LinkedList<>();
        List<Queue<Integer>> depthList = new ArrayList<>();

        //** 입력 시작
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            depthList.add(new LinkedList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Math.pow(2, k) - 1; i++) {
            numberQueue.add(Integer.parseInt(st.nextToken()));
        }
        //** 입력 끝

        inOrder(numberQueue, depthList, 0, k);

        //-- 출력
        for (Queue<Integer> depth : depthList) {
            for (Integer number : depth) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
