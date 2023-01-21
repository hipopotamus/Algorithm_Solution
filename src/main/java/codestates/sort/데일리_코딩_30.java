package codestates.sort;

/*
코드스테이츠 코플릿 데일리코딩 30번째 문제
문제
부분적으로 오름차순 정렬*된 정수의 배열(rotated)과 정수(target)를 입력받아 target의 인덱스를 리턴해야 합니다.
부분적으로 정렬된 배열: 배열을 왼쪽 혹은 오른쪽으로 0칸 이상 순환 이동할 경우 완전히 정렬되는 배열
예시: [4, 5, 6, 0, 1, 2, 3]은 왼쪽으로 3칸 또는 오른쪽으로 4칸 순환 이동할 경우 완전히 정렬됩니다.
입력
인자 1 : rotated
int 타입을 요소로 갖는 배열
rotated[i]는 정수
인자 2 : target
int 타입의 정수
출력
int 타입을 리턴해야 합니다.
주의사항
rotated에 중복된 요소는 없습니다.
target이 없는 경우, -1을 리턴해야 합니다.
입출력 예시
int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
System.out.println(output) // --> 5
int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);
System.out.println(output) // --> -1
*/

public class 데일리_코딩_30 {

    public int rotatedArraySearch(int[] rotated, int target) {
        int start = 0;
        int end = rotated.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (rotated[middle] == target) {
                return middle;
            }
            //왼쪽이 정렬된 경우
            if (rotated[start] < rotated[middle]) {
                //target이 왼쪽 범위에 있는 경우
                if (target >= rotated[start] && target < rotated[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
                //오른쪽이 정렬된 경우
            } else {
                //target이 오른쪽 범위에 있는 경우
                if (target > rotated[middle] && target <= rotated[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }
}
