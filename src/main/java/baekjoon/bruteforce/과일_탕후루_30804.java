package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 과일_탕후루_30804 {

    public static int extractFruit(int reservedFruit1, int reservedFruit2, int[] tanghulu) {

        int maxLength = 0;
        int right = 0;
        int left = 0;

        //탕후루 배열의 맨 앞 부터 시작해서 과일 두 종류로 이루어진 가장 긴 경우를 찾는다.
        //포인터가 가리키는 곳이 남겨야할 과일이라면 오른쪽 포인터만 오른쪽으로 이동시켜 연속되는 과일의 길이를 구한다.
        //오른쪽 포인터가 가리키는 곳이 남겨야할 과일이 아니라면 왼쪽 포인터를 오른쪽 포인터 다음으로 위치 시켜 구간을 초기화한다.
        while (right <= tanghulu.length) {

            //오른쪽 포인터가 가리키는 곳이 남겨야할 과일이 아닌경우 or 오른쪽 포인터가 배열의 길이를 넘어갔을 경우
            if (right == tanghulu.length || (tanghulu[right] != reservedFruit1 && tanghulu[right] != reservedFruit2)) {
                int length = right - left;
                if (length > maxLength) {
                    maxLength = length;
                }

                left = right + 1;
                right++;
                continue;
            }

            //오른쪽 포인터가 가리키는 곳이 남겨야 할 과일인 경우
            if (tanghulu[right] == reservedFruit1 || tanghulu[right] == reservedFruit2) {
                right++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        //*초기화 시작*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        //과일을 원소로 갖는 배열
        int[] tanghulu = new int[size];
        //과일을 중복 없이 저장하기 위한 Set
        Set<Integer> fruitSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            int fruit = Integer.parseInt(st.nextToken());
            tanghulu[i] = fruit;
            fruitSet.add(fruit);
        }
        //*초기화 끝*

        List<Integer> fruitList = new ArrayList<>(fruitSet);
        //남길 수 있는 과일의 최대 갯수를 담는 변수
        int maxSize = 0;

        //과일 종류가 2개 이하이면 탕후루의 길이를 바로 반환
        if (fruitList.size() <= 2) {
            System.out.println(tanghulu.length);
            return;
        }

        //반복문으로 탕후루에서 남길 과일 2개를 조합을 이용해서 고르고, 탕후루의 최대 길이를 구한다.
        for (int i = 0; i < fruitList.size() - 1; i++) {
            for (int j = i + 1; j < fruitList.size(); j++) {
                //탕후루에서 남길 과일
                int reservedFruit1 = fruitList.get(i);
                int reservedFruit2 = fruitList.get(j);

                int extractedTanghulu = extractFruit(reservedFruit1, reservedFruit2, tanghulu);

                if (extractedTanghulu > maxSize) {
                    maxSize = extractedTanghulu;
                }
            }
        }

        System.out.println(maxSize);
    }
}
