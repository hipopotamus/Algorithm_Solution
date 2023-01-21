package codestates.binarysearch;

/*
코플릿 데일리코딩 42번 문제_getItemFromTwoSortedArrays
문제
길이가 m, n이고 오름차순으로 정렬되어 있는 자연수 배열들을 입력받아 전체 요소 중 k번째 요소를 리턴해야 합니다.
입력
인자 1 : arr1
int타입을 요소로 갖는 배열
arr1.length는 m
인자 2 : arr2
int타입을 요소로 갖는 배열
arr2.length는 n
인자 3 : k
int 타입의 0 이상의 정수
출력
int 타입을 리턴해야 합니다.
주의사항
두 배열의 길이의 합은 1,000,000 이하입니다.
어떤 배열 arr의 k번째 요소는 arr[k-1]을 의미합니다.
입출력 예시
int[] arr1 = new int[]{1, 4, 8, 10};
int[] arr2 = new int[]{2, 3, 5, 9};
int result = getItemFromTwoSortedArrays(arr1, arr2, 6);
System.out.println(result); // --> 8
arr1 = new int[]{1, 1, 2, 10};
arr2 = new int[]{3, 3};
result = getItemFromTwoSortedArrays(arr1, arr2, 4);
System.out.println(result); // --> 3
Advanced
단순히 처음부터 끝까지 찾아보는 방법(O(K)) 대신 다른 방법(O(logK))을 탐구해 보세요.
힌트
이진 탐색(binary search)을 응용하여 해결합니다.
*/


public class 데일리_코딩_42 {

    //k번째 수 = k아래로 k -1 개의 원소가 있다.
    //k를 반으로 나누어 각 배열을 카운트 한다.
    public int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        //각 배열의 시작지점 index
        int arr1Index = 0;
        int arr2Index = 0;

        //k가 0이 될때 까지 = 카운트가 끝날 때 까지
        while (k > 0) {
            //cnt = 각 배열에서 카운트해야하는 개수
            int cnt = (int) Math.ceil(((double) k / 2));
            int arr1Cnt = cnt;
            int arr2Cnt = cnt;

            //카운트 해야할 숫자가 남아있는데 배열에 더이상 카운트할 원소가 없을 경우
            //반대 배열에 k(카운트 해야하는 수)를 몰아주고 반복문을 나온다.
            if (arr1Index == arr1.length) {
                arr2Index += k;
                break;
            }
            if (arr2Index == arr2.length) {
                arr1Index += k;
                break;
            }

            //카운트해야하는 수보다 남은 배열의 수가 적을 경우 남은 배열의 수를 카운트 할 수로 바꾼다.
            arr1Cnt = Math.min(arr1Cnt, arr1.length - arr1Index);
            arr2Cnt = Math.min(arr2Cnt, arr2.length - arr2Index);

            //배열에서 카운트했을 때 마지막 원소를 비교해서 작은 쪽을 카운트 한다.
            //카운트 한다 = 시작 인덱스를 카운트 할 수만큼 늘린다.
            //카운트 하면 카운트 한 만큼 k에서 값을 빼준다.
            if (arr1[arr1Index + arr1Cnt - 1] < arr2[arr2Index + arr2Cnt - 1]) {
                arr1Index += arr1Cnt;
                k -= arr1Cnt;
            } else {
                arr2Index += arr2Cnt;
                k -= arr2Cnt;
            }
        }
        return Math.max(arr1[arr1Index - 1], arr2[arr2Index - 1]);
    }
}
