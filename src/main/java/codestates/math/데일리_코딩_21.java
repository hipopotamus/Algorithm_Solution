package codestates.math;

/*
코드스테이츠 코플릿 데일리코딩 21번 문제
문제
정수를 요소로 갖는 배열을 입력받아 3개의 요소를 곱해 나올 수 있는 최대값을 리턴해야 합니다.
입력
인자 1 : arr
int 타입을 요소로 갖는 임의의 배열
출력
int 타입을 리턴해야 합니다.
주의사항
입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
배열의 요소는 음수와 0을 포함하는 정수입니다.
배열의 길이는 3 이상입니다.
*/

public class 데일리_코딩_21 {
    int result = 0;

    public void combination(int index, int count, int comb, int[] arr) {   //3개 숫자의 조합을 찾는 메서드
        if (count == 3) {   //탈출조건 : 4번 재귀가 돌았을 때
            if (comb > result) {
                result = comb;
            }
            return;
        }

        int nextCount = count + 1;
        for (int nextIndex = index; nextIndex < arr.length; nextIndex++) {   //"현재" 매개변수로 주어진 인덱스 부터 시작한다
            int tempComb = comb * arr[nextIndex];
            combination(nextIndex + 1, nextCount, tempComb, arr);   //인덱스는 + 1을 해서 넘겨주고, 반복문의 nextIndex의 값을 곱한 값을 넘겨준다.
            //해당 인덱스의 전 단계의 결과값이 넘어가게 된다.
        }
    }

    public int largestProductOfThree(int[] arr) {
        // TODO:
        result = arr[0] * arr[1] * arr[2];
        combination(0, 0, 1, arr);
        return result;
    }
}
