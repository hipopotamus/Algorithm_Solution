package solution;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {

    public int[] solution(String msg) {
        List<String> dict = new ArrayList<>();
        dict.add(null);

        for (char i = 'A'; i <= 'Z'; i++) {
            dict.add(String.valueOf(i));
        }

        return zip(dict, msg);
    }

    public int[] zip(List<String> dict, String msg) {
        ArrayList<Integer> result = new ArrayList<>();

        String input = "";
        int start = 0;
        while (start < msg.length()) {

            int end = start + 1;
            while (end <= msg.length()) {

                input = msg.substring(start, end);
                if (dict.contains(input)) {
                    if (end == msg.length()) {
                        result.add(dict.indexOf(input));
                        end++;
                        break;
                    }
                    end++;
                } else {
                    dict.add(input);
                    result.add(dict.indexOf(msg.substring(start, end - 1)));
                    break;
                }
            }
            start = end - 1;
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Test
    public void solutionTest() {
    }
}