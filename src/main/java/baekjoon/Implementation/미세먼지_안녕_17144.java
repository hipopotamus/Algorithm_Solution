package baekjoon.Implementation;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class 미세먼지_안녕_17144 {
    static int[] rowSet = {-1, 0, 1, 0};
    static int[] colSet = {0, 1, 0, -1};

    public static class AirConditioner {   //공기청정기 구현
        Point top;
        Point bottom;

        public AirConditioner() {
        }

        public void setAirConditioner(Point point) {   //공기청정기의 "위"와 "아래"의 위치 세팅
            if (top == null) {
                this.top = point;
            } else {
                this.bottom = point;
            }
        }

        public void cycle(Dust[][] dusts, int rowSize, int colSize) {   //주어진 2차배열의 공기를 순환시키는 메서드

            for (int i = 1; i < this.top.x; i++) {   //공기청정기의 윗부분부터 반시계 방향으로 Dust를 덮어쓰면서 Dust의 위치를 이동
                dusts[this.top.x - i][0] = dusts[this.top.x - i - 1][0];
            }
            for (int i = 0; i < colSize - 1; i++) {
                dusts[0][i] = dusts[0][i + 1];
            }
            for (int i = 0; i < this.top.x; i++) {
                dusts[i][colSize - 1] = dusts[i + 1][colSize - 1];
            }
            for (int i = 0; i < colSize - 2; i++) {
                dusts[this.top.x][colSize - 1 - i] = dusts[this.top.x][colSize - 2 - i];
            }
            dusts[this.top.x][this.top.y + 1] = new Dust(0);

            int downSize = rowSize - 1 - this.bottom.x;
            for (int i = 1; i < downSize; i++) {   ////공기청정기의 아랫부분부터 시계 방향으로 Dust를 덮어쓰면서 Dust의 위치를 이동
                dusts[this.bottom.x + i][0] = dusts[this.bottom.x + i + 1][0];
            }
            for (int i = 0; i < colSize - 1; i++) {
                dusts[rowSize - 1][i] = dusts[rowSize - 1][i + 1];
            }
            for (int i = 0; i < downSize; i++) {
                dusts[rowSize - 1 - i][colSize - 1] = dusts[rowSize - 2 - i][colSize - 1];
            }
            for (int i = 0; i < colSize - 2; i++) {
                dusts[this.bottom.x][colSize - 1 - i] = dusts[this.bottom.x][colSize - 2 - i];
            }
            dusts[this.bottom.x][this.bottom.y + 1] = new Dust(0);
        }
    }

    public static class Dust {   //미세먼지 구현
        int size;
        int addSize = 0;   //확산된 미세먼지를 일시적으로 저장하는 필드

        public Dust(int size) {
            this.size = size;
        }

        public void sum() {   //확산된 미세먼지를 본 미세먼지의 양에 더해주는 메서드
            this.size += addSize;
            addSize = 0;
        }

        public void diffusion(Dust[][] dusts, AirConditioner airConditioner,
                              int rowSize, int colSize, int row, int col) {   //미세먼지를 확산시키는 메서드
            int dustSize = this.size;   //확산되는 미세먼지의 양은 확산되기 전의 미세먼지의 양에의해 결정되므로 초기 미세먼지 양을 저장
            for (int k = 0; k < 4; k++) {
                int nextRow = row + rowSet[k];
                int nextCol = col + colSet[k];
                if (nextRow < 0 || nextRow > rowSize - 1 || nextCol < 0 || nextCol > colSize - 1 ||
                        (nextRow == airConditioner.top.x && nextCol == airConditioner.top.y) ||
                        (nextRow == airConditioner.bottom.x && nextCol == airConditioner.bottom.y)) {   //범위를 벗어나는 값과 공기청정기의 위치는 확산하지 않는다.
                    continue;
                }
                dusts[nextRow][nextCol].addSize += dustSize / 5;
                this.size -= dustSize / 5;
            }
        }
    }

    public static void simulationDust_Diffusion(Dust[][] dusts, AirConditioner airConditioner,
                                                int rowSize, int colSize) {   //주어진 배열을 순회하며 Dust.diffusion을 실행
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                Dust dust = dusts[i][j];
                if (dust == null || dust.size == 0) {
                    continue;
                }
                dust.diffusion(dusts, airConditioner, rowSize, colSize, i, j);
            }
        }
    }

    public static void simulationDust_Sum(Dust[][] dusts, int rowSize, int colSize) {   //주어진 배열을 순회하며 Dust.sum을 실행
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                Dust dust = dusts[i][j];
                if (dust == null) {
                    continue;
                }
                dust.sum();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowSize = scanner.nextInt();
        int colSize = scanner.nextInt();
        int totalTime = scanner.nextInt();

        AirConditioner airConditioner = new AirConditioner();
        Dust[][] dusts = new Dust[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {   //입력된 dustSize로 dusts에 Dust를 초기화
            for (int j = 0; j < colSize; j++) {
                int dustSize = scanner.nextInt();
                if (dustSize == -1) {   // dustSize = -1 => 공기청정기의 위치이기 때문에 해당 위치로 airCondtioner의 필드값을 초기화
                    airConditioner.setAirConditioner(new Point(i, j));
                    continue;
                }
                dusts[i][j] = new Dust(dustSize);
            }
        }

        for (int i = 0; i < totalTime; i++) {   //주어진 시간만큼 시뮬레이션 실행
            simulationDust_Diffusion(dusts, airConditioner, rowSize, colSize);
            simulationDust_Sum(dusts, rowSize, colSize);
            airConditioner.cycle(dusts, rowSize, colSize);
        }

        int result = Arrays.stream(dusts)   //dusts에서 null값을 제외하고 모든 Dust의 size 합을 구한다.
                .flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .mapToInt(dust -> dust.size).sum();

        System.out.println(result);
    }
}
