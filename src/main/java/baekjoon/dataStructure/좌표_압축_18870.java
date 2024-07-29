package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class 좌표_압축_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //** 입력 시작
        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer> coordinateList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            coordinateList.add(Integer.parseInt(st.nextToken()));
        }
        //** 입력 끝

        //특정 숫자보다 작은 숫자의 개수를 셀 때 중복은 허용하지 않기 때문에 TreeSet을 사용
        //(좌표, 압축된 좌표) 형식으로 저장할 맵을 생성
        TreeSet<Integer> coordinateSet = new TreeSet<>(coordinateList);
        HashMap<Integer, Integer> coordinateMap = new HashMap<>();
        int compressedCoordinate = 0;

        //Set에서 좌표를 하나씩 꺼내어서 센다.
        //좌표값과 카운트한 값(압축된 좌표)을 맵에 넣어준다.
        for (int coordinate : coordinateSet) {
            coordinateMap.put(coordinate, compressedCoordinate);
            compressedCoordinate++;
        }

        //출력
        for (int coordinate : coordinateList) {
            Integer compactCoordinate = coordinateMap.get(coordinate);
            bw.write(String.valueOf(compactCoordinate));
            bw.write(" ");
        }

        bw.flush();
    }
}
