package programmers.bfs;

import java.util.*;

public class 순위 {

    private static class Info {
        int number;
        HashSet<Integer> up = new HashSet<>();
        HashSet<Integer> down = new HashSet<>();
        boolean isGrade = false;
        boolean check = false;

        public Info(int number) {
            this.number = number;
        }

        public void checkGrade(int n) {
            if (n - 1 == up.size() + down.size()) {
                this.isGrade = true;
            }
        }


        //매개변수 Info의 이긴 정보와 진 정보를 추가함
        public void extendUp(Info superInfo) {
            this.up.addAll(superInfo.up);
        }

        public void extendDown(Info superInfo) {
            this.down.addAll(superInfo.down);
        }
    }

    public void bfs(Info start, Info[] infos, ArrayList<ArrayList<Integer>> edge, boolean isUp) {
        Queue<Info> queue = new LinkedList<>();
        start.check = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            for (Integer number : edge.get(info.number)) {
                if (infos[number].check) {
                    continue;
                }
                infos[number].check = true;
                if (isUp) {
                    infos[number].extendUp(info);
                } else {
                    infos[number].extendDown(info);
                }
                queue.offer(infos[number]);
            }
        }
    }

    public int solution(int n, int[][] results) {
        Info[] infos = new Info[n + 1];
        ArrayList<ArrayList<Integer>> upEdge = new ArrayList<>();   //이긴 정보가 전달되는 간선
        ArrayList<ArrayList<Integer>> downEdge = new ArrayList<>();   //진 정보가 전달되는 간선

        //초기화 시작
        for (int i = 0; i <= n; i++) {
            infos[i] = new Info(i);
            upEdge.add(new ArrayList<>());
            downEdge.add(new ArrayList<>());
        }
        for (int[] result : results) {
            infos[result[0]].down.add(result[1]);
            infos[result[1]].up.add(result[0]);
            upEdge.get(result[0]).add(result[1]);
            downEdge.get(result[1]).add(result[0]);
        }
        //초기화 끝

        //bfs로 "모든 노드를 시작"으로 탐색하며 진 정보와 이긴 정보를 전달
        for (int i = 1; i <= n; i++) {
            for (Info info : infos) {
                info.check = false;
            }
            bfs(infos[i], infos, upEdge, true);

            for (Info info : infos) {
                info.check = false;
            }
            bfs(infos[i], infos, downEdge, false);
        }

        //순위를 정할 수 있는지 판단(이긴 정보 + 진 정보 + 1 == 전체 노드 개수)
        for (int i = 1; i <= n; i++) {
            infos[i].checkGrade(n);
        }

        long count = Arrays.stream(infos)
                .filter(info -> info.isGrade)
                .count();
        return (int) count;
    }
}
