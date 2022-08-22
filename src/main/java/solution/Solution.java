package solution;

/*
코플릿 데일리코딩 38번 문제_mergeSort

문제
정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

입력
인자 1 : arr
- int 타입을 요소로 갖는 배열
- arr[i]는 정수
- arr.length 100,000 이하

출력
- int 타입을 요소로 갖는 배열을 리턴해야 합니다.
- 배열의 요소는 오름차순으로 정렬되어야 합니다.
- arr[i] <= arr[j] (i < j)

주의사항
- 병합 정렬을 구현해야 합니다.
- Arrays.sort 사용은 금지됩니다.
- 입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

입출력 예시
int[] output = mergeSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]

힌트
병합 정렬은 표준 라이브러리에서 정렬을 구현할 때 퀵 정렬이나 힙 정렬의 대안으로 사용하는 최적화된 정렬 알고리즘입니다. 병합 정렬은 다음과 같은 알고리즘을 사용합니다.

N의 길이를 가진 배열 리스트를 1의 길이를 가진 "부분 리스트"가 N개 모인 것으로 취급합니다.
인접한 부분 리스트들을 정렬하여 2의 길이를 가진 부분 리스트로 병합합니다.
2의 길이를 가진 인접한 부분 리스트들을 4의 길이를 가진 부분 리스트로 합칩니다.
하나의 정렬된 리스트가 될 때까지 위 과정을 반복합니다.
N이 홀수라면, 첫 번째 병합 때 1의 길이를 가진 부분 리스트를 남깁니다.
병합 정렬은 두 가지 방식으로 구현 가능합니다. 재귀적 접근(위->아래) 그리고 반복적 접근(아래->위)


반복적 접근

1. 주어진 배열이 "정렬된" 부분 리스트로 나뉘어집니다.
[4,7,4,3,9,1,2] -> [[4],[7],[4],[3],[9],[1],[2]]

2. 인접한 부분 리스트 2개가 정렬된 부분 리스트로 병합됩니다.
[[4],[7],[4],[3],[9],[1],[2]] -> [[4,7],[3,4],[1,9],[2]]

2. 병합 과정 (반복) :
[[4,7],[3,4],[1,9],[2]] -> [[3,4,4,7], [1,2,9]]

2. 병합 과정 (반복) :
[[3,4,4,7], [1,2,9]] -> [[1,2,3,4,4,7,9]]

3. 마무리 : 정렬된 배열이 리턴됩니다.
[1,2,3,4,4,7,9]
*/

import java.util.ArrayList;

public class Solution {

    //list안에 인접한 list를 반복해서 합치는 메서드
    private ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> list) {
        //반복문에서 사용될 병합되기 전 list
        ArrayList<ArrayList<Integer>> tempList = list;

        //반복문을 돌리며 인접한 list를 병합한다.
        do {
            //병합된 리스트들을 담을 리스트
            ArrayList<ArrayList<Integer>> nextList = new ArrayList<>();

            //반복문으로 인접한 리스트를 병합하고 nextList에 넣어준다.
            for (int i = 0; i < tempList.size() - 1; i += 2) {
                ArrayList<Integer> leftList = tempList.get(i);
                ArrayList<Integer> rightList = tempList.get(i + 1);
                ArrayList<Integer> sort = sort(leftList, rightList);
                nextList.add(sort);
            }
            //병합되기 전 list가 홀수이면 마지막 list를 nextList에 넣어준다.
            if (tempList.size() % 2 != 0) {
                nextList.add(tempList.get(tempList.size() - 1));
            }
            tempList = nextList;
        } while (tempList.size() > 1);
        return tempList.get(0);
    }

    //두 정렬된 list를 합쳐서 정렬하는 메서드
    private ArrayList<Integer> sort(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        //합쳐서 정렬된 값들을 담을 list
        ArrayList<Integer> list = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;
        //두 리스트의 시작점 부터 비교해서 값이 적은 값부터 list에 넣는다.
        while (leftIndex < leftList.size() && rightIndex < rightList.size()) {
            Integer leftElements = leftList.get(leftIndex);
            Integer rightElements = rightList.get(rightIndex);
            if (leftElements <= rightElements) {
                list.add(leftList.get(leftIndex));
                leftIndex++;
            } else {
                list.add(rightList.get(rightIndex));
                rightIndex++;
            }
        }
        //만약 list에 들어가지 않은 값이 있으면 추가적으로 넣어준다.
        if (leftIndex < leftList.size()) {
            while (leftIndex < leftList.size()) {
                list.add(leftList.get(leftIndex));
                leftIndex++;
            }
        } else if (rightIndex < rightList.size()) {
            while (rightIndex < rightList.size()) {
                list.add(rightList.get(rightIndex));
                rightIndex++;
            }
        }
        return list;
    }

    public int[] mergeSort(int[] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        //arr의 각 원소 하나로 이루어진 리스트를 만들어서 list에 넣어준다.
        for (int i : arr) {
            ArrayList<Integer> dividedList = new ArrayList<>();
            dividedList.add(i);
            list.add(dividedList);
        }

        return merge(list).stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
