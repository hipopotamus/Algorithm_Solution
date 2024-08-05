package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 밤양갱_31926 {

    //daldidalgo 만드는데 8초, daldidan 만드는데 2초
    //daldidalgo를 만들면 그 이후 부터는 daldidalgo를 복사해서 2배씩 늘릴 수 있다.
    //daldidalgo 전체를 계속 복사해서 목표 개수에 맞춰지면 2초를 추가해준다(daldidan 만드는 시간)
    //목표 개수를 넘었으면 1초를 추가해준다.(n붙이는 시간)
    public static int getTime(int target) {
        int dalCount = 1;
        int totalTime = 8;

        while (dalCount < target) {
            dalCount *= 2;
            totalTime++;
        }

        if (dalCount == target) {
            totalTime += 2;
        } else {
            totalTime++;
        }

        return totalTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        int totalTime = getTime(target);

        System.out.println(totalTime);
    }
}
