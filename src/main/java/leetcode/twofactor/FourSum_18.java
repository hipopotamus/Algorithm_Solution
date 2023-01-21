package leetcode.twofactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FourSum_18 {

    private int setIndex(int firstIndex, int secondIndex, int index, boolean isStart) {   //start, end 포인터를 설정 및 이동시키는 메서드
        if (isStart) {
            if (index == firstIndex || index == secondIndex) {
                if (index + 1 == firstIndex || index + 1 == secondIndex) {
                    return index + 2;
                }
                return index + 1;
            }
        } else {
            if (index == firstIndex || index == secondIndex) {
                if (index - 1 == firstIndex || index - 1 == secondIndex) {
                    return index - 2;
                }
                return index - 1;
            }
        }
        return index;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 4) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int selectedN1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {   //i, j 위치의 두 개의 숫자를 선택
                int selectedN2 = nums[j];
                long newTarget = (long)target - selectedN1 - selectedN2;   //선택된 숫자들을 뺀 새로운 타겟 생성

                int start = setIndex(i, j, 0, true);
                int end = setIndex(i, j, nums.length - 1, false);

                while (start != end) {   //Two Pointer를 사용해서 합이 newTarget과 일치하는 두 숫자를 선택
                    int sum = nums[start] + nums[end];

                    if (sum == newTarget) {
                        ArrayList<Integer> resultList = new ArrayList<>(List.of(nums[i], nums[j], nums[start], nums[end]));
                        resultList.sort(Comparator.naturalOrder());
                        if (!result.contains(resultList)) {   //중복 제거
                            result.add(resultList);
                        }
                    }

                    if (sum < newTarget) {
                        start = setIndex(i, j, start + 1, true);
                    }
                    if (sum >= newTarget) {
                        end = setIndex(i, j, end - 1, false);
                    }
                }
            }
        }
        return result;
    }
}
