package solution;

/*
백준 1300번 문제_K번째 수
https://www.acmicpc.net/problem/1300
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        long left = 1;
        long right = target;

        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;

            //mid와 같거나 작은 원소의 개수를 구한다.
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            //mid와 같거나 작은 원소의 개수(count)가 target보다 크면 오른쪽 탐색
            if (count >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
