package codingtest.kakao2019_겨울_인턴쉽;

import java.util.Deque;
import java.util.LinkedList;

public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            if (deque.isEmpty()) {
                deque.offer(i);
            }

            Integer frontIndex = deque.peek();
            if (i - frontIndex >= k) {
                deque.poll();
            }

            while (!deque.isEmpty()) {
                if (stones[deque.peekLast()] <= stones[i]) {
                    deque.pollLast();
                } else {
                    break;
                }
            }
            deque.offer(i);

            if (i >= k - 1) {
                result = Math.min(result, stones[deque.peek()]);
            }
        }

        return result;
    }
}
