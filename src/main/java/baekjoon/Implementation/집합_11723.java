package baekjoon.Implementation;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 집합_11723 {

    static HashSet<Integer> allSet = new HashSet<>();

    private static void add(HashSet<Integer> set, int number) {
        set.add(number);
    }

    private static void remove(HashSet<Integer> set, int number) {
        set.remove(number);
    }

    private static int check(HashSet<Integer> set, int number) {
        return set.contains(number) ? 1 : 0;
    }

    private static boolean toggle(HashSet<Integer> set, int number) {
        return set.contains(number) ? set.remove(number) : set.add(number);
    }

    private static void all(HashSet<Integer> set) {
        set.clear();
        set.addAll(allSet);
    }

    private static void empty(HashSet<Integer> set) {
        set.clear();
    }

    private static void calculateSet(BufferedReader br, BufferedWriter bw, HashSet<Integer> set) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String command = st.nextToken();
        int number = 0;
        if (!command.equals("all") && !command.equals("empty")) {
            number = Integer.parseInt(st.nextToken());
        }

        switch (command) {
            case "add":
                add(set, number);
                break;
            case "remove":
                remove(set, number);
                break;
            case "toggle":
                toggle(set, number);
                break;
            case "check":
                bw.write(String.valueOf(check(set, number)));
                bw.newLine();
                break;
            case "all":
                all(set);
                break;
            case "empty":
                empty(set);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<Integer> set = new HashSet<>();

        int size = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 20; i++) {
            allSet.add(i);
        }

        for (int i = 0; i < size; i++) {
            calculateSet(br, bw, set);
        }

        bw.flush();
    }
}
