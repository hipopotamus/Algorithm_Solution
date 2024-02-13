package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class 좌표_압축_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer> coordinateList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            coordinateList.add(Integer.parseInt(st.nextToken()));
        }

        TreeSet<Integer> coordinateSet = new TreeSet<>(coordinateList);
        HashMap<Integer, Integer> coordinateMap = new HashMap<>();
        int compressedCoordinate = 0;

        for (int coordinate : coordinateSet) {
            coordinateMap.put(coordinate, compressedCoordinate);
            compressedCoordinate++;
        }

        for (int coordinate : coordinateList) {
            Integer compactCoordinate = coordinateMap.get(coordinate);
            bw.write(String.valueOf(compactCoordinate));
            bw.write(" ");
        }

        bw.flush();
    }
}
