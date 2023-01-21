package leetcode.twofactor;

import java.util.Arrays;

public class TreeSum_Closest_16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = 100000;

        for (int i = 0; i < nums.length; i++) {   //숫자 하나 선택
            int newTarget = target - nums[i];   //target에서 선택한 숫자만큼 뺀 값을 newTarget으로 정의

            int start = 0;   //start, end point 설정, 선택한 숫자의 인덱스와 겹치면 변경
            if (i == start) {
                start++;
            }
            int end = nums.length - 1;
            if (i == end) {
                end--;
            }

            while (start != end) {   //newTarget에 근접하는 방향으로 start, end를 움직이면서 합을 구함
                int sum = nums[start] + nums[end];
                if (sum == newTarget) {   //숫자의 합이 target과 동일한 경우가 있다면 target을 바로 반환
                    return target;
                }

                if (sum < newTarget) {
                    if (start + 1 == i) {
                        start += 2;
                    } else {
                        start++;
                    }
                }
                if (sum >= newTarget) {
                    if (end - 1 == i) {
                        end -= 2;
                    } else {
                        end--;
                    }
                }

                if (Math.abs(sum - newTarget) < Math.abs(minDiff)) {   //target과 가장 작은 차이가 나는 값을 갱신
                    minDiff = sum - newTarget;
                }
            }
        }

        return target + minDiff;
    }
}
