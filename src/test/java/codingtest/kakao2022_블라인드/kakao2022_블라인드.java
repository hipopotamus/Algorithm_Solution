package codingtest.kakao2022_블라인드;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class kakao2022_블라인드 {

    @Test
    public void 신고_결과_받기_Test() {
        신고_결과_받기 test = new 신고_결과_받기();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] solution = test.solution(id_list, report, k);

        Arrays.stream(solution).forEach(System.out::println);
    }

    @Test
    public void k진수에서_소수_개수_구하기_Test() {
        k진수에서_소수_개수_구하기 test = new k진수에서_소수_개수_구하기();
        int solution = test.solution(110011, 10);
        System.out.println(solution);
    }

    @Test
    public void 주차_요금_계산_Test() {
        주차_요금_계산 test = new 주차_요금_계산();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] solution = test.solution(fees, records);

        Arrays.stream(solution).forEach(System.out::println);
    }

    @Test
    public void 양궁_대회_Test() {
        양궁_대회 test = new 양궁_대회();
        int[] info = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int n = 1;
        int[] solution = test.solution(n, info);
        Arrays.stream(solution).forEach(s -> System.out.print(s + " "));
    }

}