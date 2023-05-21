package codingtest.summer_winter_coding_2018;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class summer_winter_coding_2018_Test {

    @Test
    public void 영어_끝말있기Test() {
        영어_끝말있기 test = new 영어_끝말있기();
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 3;

        int[] solution = test.solution(n, words);
        System.out.printf(Arrays.toString(solution));
    }

    @Test
    public void 스킬트리Test() {
        스킬트리 test = new 스킬트리();
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        String skill = "CBD";

        int solution = test.solution(skill, skill_trees);
        System.out.println(solution);
    }

    @Test
    public void 방문_길이_Test() {
        방문_길이 test = new 방문_길이();
        String dirs = "ULURRDLLU";

        int solution = test.solution(dirs);
        System.out.println(solution);
    }

}