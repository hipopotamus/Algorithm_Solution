package baekjoon.dataStructure;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 통계학_2108 {

    private static int getMean(int sum, int size) {
        return (int) Math.round((double) sum / (double) size);
    }

    private static int getMedian(List<Integer> numberList) {
        numberList.sort(Comparator.naturalOrder());
        return numberList.get(numberList.size() / 2);
    }

    private static int getMode(Map<Integer, Integer> numberCountMap) {
        Integer maxCount = numberCountMap.values().stream()
                .max(Integer::compare)
                .get();

        PriorityQueue<Integer> modeQueue = numberCountMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxCount))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(PriorityQueue::new));

        int mode = 0;
        if (modeQueue.size() > 1) {
            modeQueue.poll();
            mode = modeQueue.poll();
        } else if (modeQueue.size() == 1) {
            mode = modeQueue.poll();
        }
        return mode;
    }

    private static int getRange(List<Integer> numberList) {
        Integer min = numberList.stream().min(Comparator.naturalOrder()).get();
        Integer max = numberList.stream().max(Comparator.naturalOrder()).get();

        return max - min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        List<Integer> numberList = new ArrayList<>();
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(br.readLine());
            sum += number;
            numberList.add(number);
            numberCountMap.put(number, numberCountMap.getOrDefault(number, 0) + 1);
        }

        int mean = getMean(sum, numberList.size());
        int median = getMedian(numberList);
        int mode = getMode(numberCountMap);
        int range = getRange(numberList);

        sb.append(mean).append("\n")
                .append(median).append("\n")
                .append(mode).append("\n")
                .append(range).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
