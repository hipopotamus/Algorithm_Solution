package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.*;

public class 이상한_아리의_채점_25167 {

    public static class Contestant {
        String name;
        int totalScore = 0;
        ScoreInfo[] scoreInfos;

        public Contestant(String name, ScoreInfo[] scoreInfos) {
            this.name = name;
            this.scoreInfos = scoreInfos;
        }
    }

    public static class ScoreInfo {
        Integer wrongTime;
        Integer solvedTime;
        boolean isFirstSolved = false;

        public ScoreInfo() {
        }
    }

    public static List<Contestant> getScore(Map<String, Contestant> contestantMap, int problemSize, int peopleSize) {
        ArrayList<Contestant> contestantList = new ArrayList<>(contestantMap.values());

        for (int i = 1; i <= problemSize; i++) {
            int index = i;
            int score = 1;
            contestantList.sort(Comparator.comparing(info -> info.name));
            contestantList.sort(Comparator.comparing(info -> info.scoreInfos[index].solvedTime, Comparator.nullsFirst(Integer::compareTo)));

            for (Contestant contestant : contestantList) {
                ScoreInfo scoreInfo = contestant.scoreInfos[index];
                if (scoreInfo.solvedTime == null && (scoreInfo.isFirstSolved || scoreInfo.wrongTime == null)) {
                    contestant.totalScore += peopleSize + 1;
                    continue;
                }

                if (scoreInfo.solvedTime == null) {
                    contestant.totalScore += peopleSize;
                    continue;
                }

                contestant.totalScore += score++;
            }
        }

        contestantList.sort(Comparator.comparing(info -> info.name));
        contestantList.sort(Comparator.comparing(info -> info.totalScore));

        return contestantList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int problemSize = Integer.parseInt(st.nextToken());
        int constantSize = Integer.parseInt(st.nextToken());
        int infoSize = Integer.parseInt(st.nextToken());

        HashMap<String, Contestant> contestantMap = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < constantSize; i++) {
            String name = st.nextToken();

            ScoreInfo[] scoreInfos = new ScoreInfo[problemSize + 1];
            for (int j = 1; j < scoreInfos.length; j++) {
                scoreInfos[j] = new ScoreInfo();
            }

            Contestant contestant = new Contestant(name, scoreInfos);
            contestantMap.put(name, contestant);
        }

        for (int i = 0; i < infoSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int problemNumber = Integer.parseInt(st.nextToken());
            int time = LocalTime.parse(st.nextToken()).toSecondOfDay() / 60;
            String name = st.nextToken();
            String result = st.nextToken();

            Contestant contestant = contestantMap.get(name);
            ScoreInfo scoreInfo = contestant.scoreInfos[problemNumber];

            if (scoreInfo.isFirstSolved || scoreInfo.solvedTime != null) {
                continue;
            }

            if (result.equals("wrong")) {
                if (scoreInfo.wrongTime != null) {
                    continue;
                }
                scoreInfo.wrongTime = time;
            } else if (result.equals("solve")) {
                if (scoreInfo.wrongTime == null) {
                    scoreInfo.isFirstSolved = true;
                } else {
                    scoreInfo.solvedTime = time - scoreInfo.wrongTime;
                }
            }
        }

        List<Contestant> contestantList = getScore(contestantMap, problemSize, constantSize);

        for (Contestant contestant : contestantList) {
            System.out.println(contestant.name);
        }
    }
}
