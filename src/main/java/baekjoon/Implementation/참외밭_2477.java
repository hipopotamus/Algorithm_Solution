package baekjoon.Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class 참외밭_2477 {

    public static class Side {
        int length;
        String direction;

        public Side(int length) {
            this.length = length;
        }
    }

    public static int calculateArea(Side[] sideArr) {
        int totalWidth = 0;
        int totalHeight = 0;

        //각 방향의 모든 변의 합 = 큰 사각형의 가로 세로
        for (int i = 1; i < 7; i++) {
            if (sideArr[i].direction.equals("width")) {
                totalWidth += sideArr[i].length;
            } else if (sideArr[i].direction.equals("height")) {
                totalHeight += sideArr[i].length;
            }
        }

        totalWidth /= 2;
        totalHeight /= 2;

        int totalArea = totalWidth * totalHeight;
        int voidArea = calculateVoidArea(sideArr, totalWidth, totalHeight);

        return totalArea - voidArea;
    }

    public static int calculateVoidArea(Side[] sideArr, int totalWidth, int totalHeight) {
        int voidWidth = 0;
        int voidHeight = 0;

        //연결된 변의 길이가 전체 사각형의 변의 길이와 같다면 꺾여진 부분임을 뜻함
        for (int i = 1; i < 7; i++) {
            if (sideArr[i].direction.equals("width") && sideArr[i - 1].length + sideArr[i + 1].length == totalHeight) {
                voidWidth = sideArr[i].length;
            } else if (sideArr[i].direction.equals("height") && sideArr[i - 1].length + sideArr[i + 1].length == totalWidth) {
                voidHeight = sideArr[i].length;
            }
        }

        return voidWidth * voidHeight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int kMelon = Integer.parseInt(br.readLine());
        Side[] sideArr = new Side[8];

        for (int i = 1; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            sideArr[i] = new Side(length);

            if (direction == 1 || direction == 2) {
                sideArr[i].direction = "width";
            } else {
                sideArr[i].direction = "height";
            }
        }
        sideArr[0] = sideArr[6];
        sideArr[7] = sideArr[1];

        int totalArea = calculateArea(sideArr);
        int totalKMelon = totalArea * kMelon;

        bw.write(String.valueOf(totalKMelon));
        bw.flush();
    }
}
