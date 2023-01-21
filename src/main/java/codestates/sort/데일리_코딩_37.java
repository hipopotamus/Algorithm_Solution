package codestates.sort;

/*
코드스테이츠 코플릿 데일리코딩 37번문제_radixSort
문제
정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.
입력
인자 1 : arr
- int 타입을 요소로 갖는 배열
- arr[i]는 0 이상의 정수
- arr.length 100,000 이하
출력
- int 타입을 요소로 갖는 배열을 리턴해야 합니다.
- 배열의 요소는 오름차순으로 정렬되어야 합니다.
- arr[i] <= arr[j] (i < j)
주의사항
- 기수 정렬을 구현해야 합니다.
- Arrays.sort 사용은 금지됩니다.
- 입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
입출력 예시
int[] output = radixSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]
힌트
- 기수 정렬(radix sort)은 내부적으로 계수 정렬(counting sort)을 사용합니다.
- 계수 정렬을 먼저 학습하고, 어떤 경우에 기수 정렬을 사용하는지 학습하도록 합니다.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 데일리_코딩_37 {

    //num의 index번 째 자리수를 구하는 메서드
    private int getNum(int num, int index) {
        String stringNum = String.valueOf(num);
        if ((stringNum.length() - 1 - index) < 0) {
            return 0;
        }
        String substring = stringNum.substring(stringNum.length() - 1 - index, stringNum.length() - index);
        return Integer.parseInt(substring);
    }

    public int[] radixSort(int[] arr) {
        ArrayList<Queue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queueList.add(new LinkedList<>());
        }

        int index = 0;
        while (true) {
            //각 숫자를 자리수에 따라 Queue에 넣어준다.
            for (int num : arr) {
                int selectNum = getNum(num, index);
                queueList.get(selectNum).offer(num);
            }
            //0번 째 Queue가 배열의 크기와 같다는것은 정렬이 완료됨을 의미
            if ((queueList.get(0).size() == arr.length)) {
                break;
            }
            //Queue에서 차례대로 값을 빼서 배열에 넣어준다.
            int numIndex = 0;
            for (Queue<Integer> queue : queueList) {
                while (!queue.isEmpty()) {
                    Integer num = queue.poll();
                    arr[numIndex] = num;
                    numIndex++;
                }
            }
            index++;
        }
        return arr;
    }
}
