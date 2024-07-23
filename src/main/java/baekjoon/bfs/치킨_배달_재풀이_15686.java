package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class 치킨_배달_재풀이_15686 {

    static int minChickenDist = Integer.MAX_VALUE;

    public static class Node {
        int row;
        int col;
        int status;
        int dist = 0;
        boolean isDeleted = false;
        boolean isVisited = false;

        public Node(int row, int col, int status) {
            this.row = row;
            this.col = col;
            this.status = status;
        }

        public void initNode() {
            this.dist = 0;
            this.isVisited = false;
        }
    }

    public static void initNodeArr(Node[][] nodeArr) {
        Arrays.stream(nodeArr)
                .flatMap(Arrays::stream)
                .forEach(Node::initNode);
    }

    public static int getChickenDist(Node[][] map, List<Node> shopList) {
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int chickenDist = 0;

        Queue<Node> queue = new LinkedList<>();
        for (Node shop : shopList) {
            if (shop.isDeleted) {
                continue;
            }
            shop.isVisited = true;
            queue.offer(shop);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + drow[i];
                int nextCol = node.col + dcol[i];
                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length ||
                        map[nextRow][nextCol].isVisited) {
                    continue;
                }

                Node nextNode = map[nextRow][nextCol];
                nextNode.dist = node.dist + 1;
                nextNode.isVisited = true;

                if (nextNode.status == 1) {
                    chickenDist += nextNode.dist;
                }

                queue.offer(nextNode);
            }
        }

        return chickenDist;
    }


    public static void getMinChickenDist(List<Node> shopList, int depth, int deleteNumber, int index, Node[][] map) {
        if (depth == deleteNumber) {
            initNodeArr(map);
            int chickenDist = getChickenDist(map, shopList);
            if (chickenDist < minChickenDist) {
                minChickenDist = chickenDist;
            }
            return;
        }

        for (int i = index; i < shopList.size(); i++) {
            Node shop = shopList.get(i);
            shop.isDeleted = true;
            getMinChickenDist(shopList, depth + 1, deleteNumber, i + 1, map);
            shop.isDeleted = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Node> shopList = new ArrayList<>();
        int deleteNumber;

        int mapSize = Integer.parseInt(st.nextToken());
        int liveNumber = Integer.parseInt(st.nextToken());

        Node[][] map = new Node[mapSize][mapSize];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                int status = Integer.parseInt(st.nextToken());
                map[i][j] = new Node(i, j, status);

                if (status == 2) {
                    shopList.add(map[i][j]);
                }
            }
        }

        deleteNumber = shopList.size() - liveNumber;

        getMinChickenDist(shopList, 0, deleteNumber, 0, map);

        bw.write(String.valueOf(minChickenDist));
        bw.flush();
    }
}
