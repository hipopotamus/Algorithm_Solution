package solution;

/*
코드스테이츠 코플릿 데일리코딩 9번 문제_집밥이 그리워

집밥이 그리워
문제
김코딩은 몇 년의 해외 출장 끝에 본가에 내려왔습니다. 오랜만에 보는 김코딩의 얼굴에 반가웠던 부모님은 상다리가 부러질 정도로 음식을 만들었습니다.
감동의 재회도 잠시, 의자에 앉아 식사를 하려던 김코딩은 무엇부터 먹어야 될지 깊은 생각에 빠졌습니다.
정성스럽게 차려 주신 만큼, 최대한 많은 방법으로 다양하게 먹고 싶었기 때문입니다.

밥은 한 가지이며 반찬은 다수일 때, 밥과 함께 먹을 수 있는 반찬의 모든 경우의 수를 배열에 담아 리턴하세요.

입력
인자 1: sideDishes
String 타입의 영문으로 된 반찬이 나열되어 있는 배열

출력
ArrayList<String[]> 타입을 리턴해야 합니다.
밥과 함께 먹을 수 있는 반찬의 모든 경우의 수가 담긴 배열을 포함한 ArrayList

주의사항
반찬은 영문으로 작성이 되어 있습니다.
반찬은 중복되지 않습니다.
반찬을 먹지 않는 것도 포함됩니다. (출력되는 2차원 배열은 빈 배열을 포함합니다.)
반찬은 3개 이상 99개 이하입니다.
출력되는 배열은 전부 오름차순으로 정렬되어야 합니다.

입출력 예시
ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
System.out.println(output);
[ [],
  [eggroll, fishSoup, kimchi],
  [eggroll, fishSoup],
  [eggroll, kimchi],
  [eggroll],
  [fishSoup, kimchi],
  [fishSoup],
  [kimchi],
]
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    ArrayList<String[]> resultList = new ArrayList<>();

    private void combination(String[] sideDishes, String[] result, int start, int depth, int max) {   //조합을 구하는 메서드
        if (depth == max) {
            String[] tempResult = Arrays.copyOf(result, result.length);
            resultList.add(tempResult);
            return;
        }

        for (int i = start; i < sideDishes.length; i++) {
            result[depth] = sideDishes[i];
            combination(sideDishes, result, i + 1, depth + 1, max);
        }
    }

    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // TODO:
        Arrays.sort(sideDishes);

        resultList.add(new String[0]);
        for (int i = sideDishes.length; i >= 1; i--) {   //인덱스만큼 선택하는 조합을 구해서 resultList에 넣는다.
            String[] result = new String[i];
            combination(sideDishes, result, 0, 0, i);
        }
        resultList.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));   //구해진 부분집합들을 사전순으로 정렬한다.

        return resultList;
    }
}
