package codestates.dp;

/*
코드스테이츠 코플릿 금고를 털어라 문제
자신이 감옥에 간 사이 연인이었던 줄리아를 앤디에게 빼앗겨 화가 난 조지는 브레드, 맷과 함께 앤디 소유의 카지노 지하에 있는 금고를 털기로 합니다.
온갖 트랩을 뚫고 드디어 금고에 진입한 조지와 일행들.
조지는 이와중에 감옥에서 틈틈이 공부한 알고리즘을 이용해 target 금액을 훔칠 수 있는 방법의 경우의 수를 계산하기 시작합니다.
예를 들어 $50 을 훔칠 때 $10, $20, $50 이 있다면 다음과 같이 4 가지 방법으로 $50을 훔칠 수 있습니다.
$50 한 장을 훔친다
$20 두 장, $10 한 장을 훔친다
$20 한 장, $10 세 장을 훔친다
$10 다섯 장을 훔친다
훔치고 싶은 target 금액과 금고에 있는 돈의 종류 type 을 입력받아, 조지가 target 을 훔칠 수 있는 방법의 수를 리턴하세요.
*/

public class 금고를_털어라 {

    public long ocean(int target, int[] type) {
        long[][] dp = new long[type.length + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j < type[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - type[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
