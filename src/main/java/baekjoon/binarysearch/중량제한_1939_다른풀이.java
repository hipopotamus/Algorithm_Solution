package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class 중량제한_1939_다른풀이 {

    public static class Node {
        int number;
        boolean isVisited = false;
        Map<Node, Integer> edgeMap = new HashMap<>();

        public Node(int number) {
            this.number = number;
        }
    }

    public static boolean validateMove(Node firstNode, int maxWeight, int destination) {
        Queue<Node> queue = new LinkedList<>();

        firstNode.isVisited = true;
        queue.add(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.number == destination) {
                return true;
            }

            for (Map.Entry<Node, Integer> edge : node.edgeMap.entrySet()) {
                Node nextNode = edge.getKey();
                Integer weight = edge.getValue();

                if (nextNode.isVisited || weight < maxWeight) {
                    continue;
                }

                nextNode.isVisited = true;
                queue.offer(nextNode);
            }
        }

        return false;
    }

    public static void initNodeArr(Node[] nodeArr) {
        for (int i = 1; i < nodeArr.length; i++) {
            nodeArr[i].isVisited = false;
        }
    }

    public static int findMaxWeight(Node firstNode, int destination, Node[] nodeArr, int[] weightArr) {
        int left = 0;
        int right = weightArr.length - 1;

        while (left <= right) {
            initNodeArr(nodeArr);
            int mid = (left + right) / 2;

            if (validateMove(firstNode, weightArr[mid], destination)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return weightArr[right];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        Node[] nodeArr = new Node[size + 1];
        int[] weightArr = new int[edgeSize];
        for (int i = 1; i < nodeArr.length; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeArr[to].edgeMap.put(nodeArr[from], weight);
            nodeArr[from].edgeMap.put(nodeArr[to], weight);
            weightArr[i] = weight;
        }

        st = new StringTokenizer(br.readLine());
        int firstNumber = Integer.parseInt(st.nextToken());
        int endNumber = Integer.parseInt(st.nextToken());

        Arrays.sort(weightArr);

        int result = findMaxWeight(nodeArr[firstNumber], endNumber, nodeArr, weightArr);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
