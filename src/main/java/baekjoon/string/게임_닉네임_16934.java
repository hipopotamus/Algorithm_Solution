package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 게임_닉네임_16934 {

    public static void printHandle(HashMap<String, Integer> prefixMap, HashMap<String, Integer> nicknameMap,
                                   String nickname) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        String handle = "";

        nicknameMap.put(nickname, nicknameMap.getOrDefault(nickname, 0) + 1);

        for (int i = 0; i < nickname.length(); i++) {
            sb.append(nickname.charAt(i));
            String prefix = sb.toString();

            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);

            if (prefixMap.get(prefix) == 1 && !flag) {
                handle = prefix;
                flag = true;
            }
        }

        if (handle.isEmpty()) {
            if (nicknameMap.get(nickname) == 1) {
                handle = nickname;
            } else {
                handle = sb.append(nicknameMap.get(nickname)).toString();
            }
        }

        System.out.println(handle);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        HashMap<String, Integer> prefixMap = new HashMap<>();
        HashMap<String, Integer> nicknameMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String nickname = br.readLine();
            printHandle(prefixMap, nicknameMap, nickname);
        }
    }
}
