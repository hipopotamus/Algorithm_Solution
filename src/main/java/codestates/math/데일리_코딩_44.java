package codestates.math;

/*
코드스테이츠 코플릿 데일리코딩 44번_LSCS
문제
정수를 요소로 갖는 배열을 입력받아 다음의 조건을 만족하는 LSCS*를 리턴해야 합니다.
LSCS: 주어진 배열의 연속된 부분 배열*의 합을 구한다고 할 때, 이 중 가장 큰 값(Largest Sum of Contiguous Subarray)
연속된 부분 배열들: 배열 [1,2,3]의 연속 부분 배열은 [1], [1, 2], [1, 2, 3], [2], [2, 3], [3] 입니다.
입력
- 인자 1 : arr
- int 타입을 요소로 갖는 배열
- arr.length는 60,000 이하
- arr[i]는 -100,000 이상 100,000 이하의 정수
출력
- int 타입을 리턴해야 합니다.
주의사항
- 배열의 모든 요소가 음수인 경우도 있습니다.
입출력 예시
int output = LSCS(new int[]{1, 2, 3});
System.out.println(output); // --> 6
output = LSCS(new int[]{1, 2, 3, -4});
System.out.println(output); // --> 6 ([1, 2, 3])
output = LSCS(new int[]{1, 2, 3, -4, 5});
System.out.println(output); // --> 7 ([1, 2, 3, -4, 5])
output = LSCS(new int[]{10, -11, 11});
System.out.println(output); // --> 11 ([11])
*/

public class 데일리_코딩_44 {

    public int LSCS(int[] arr) {
        // TODO:
        //연속된 부분 배열의 가장 큰 합이 들어갈 변수
        int result = -1000000;
        //연속적으로 원소들을 더한 값
        int sum = 0;
        for (int number : arr) {
            //연속적으로 원소를 더하고 최대값을 갱신하면 result에 넣어준다.
            sum += number;
            if (sum > result) {
                result = sum;
            }

            //연속적으로 더한 값이 음수라면 뒤에 어떤 값을 더하든 값이 적어지기 때문에
            //다음 원소 부터 값을 새로 더해주기 위해 sum을 0으로 초기화한다.
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}
