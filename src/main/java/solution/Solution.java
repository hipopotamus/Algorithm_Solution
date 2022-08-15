package solution;

/*
코드스테이츠 코플릿 데일리코딩 35번째 문제

문제
정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 정수
arr.length는 100,000 이하

출력
int 타입을 요소로 갖는 배열을 리턴해야 합니다.
배열의 요소는 오름차순으로 정렬되어야 합니다.
arr[i] <= arr[j] (i < j)

주의사항
퀵 정렬을 구현해야 합니다.
arr.sort 사용은 금지됩니다.
입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

입출력 예시
int[] output = quickSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]
*/

public class Solution {
    public int[] quickSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        divide(arr, 0, arr.length -1);

        return arr;
    }

    //start와 end의 범위에서 정렬을 하고 다시 두개의 범위로 나누는 메서드
    private void divide(int[] arr, int start, int end) {
        int nextPivot = change(arr, start, end);
        //나뉘어지는 오른쪽 범위의 경우 end = nextPivot - 1이 되기 때문에 start와 겹치지 않을 경우에만 나눈다.
        if (start < nextPivot - 1) {
            divide(arr, start, nextPivot - 1);
        }
        if (end > nextPivot) {
            divide(arr, nextPivot, end);
        }
    }

    private int change(int[] arr, int start, int end) {
        int pivot = arr[(end + start) / 2];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            //end가 start보다 작아지는 경우는 위치를 바꾸지 않고 그냥 넘어간다.
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }
}
