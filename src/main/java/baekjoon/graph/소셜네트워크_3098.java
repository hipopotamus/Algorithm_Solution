package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 소셜네트워크_3098 {

    static int days = 0;
    static List<Integer> countFriends = new ArrayList<>();

    public static class People {
        int number;
        Set<People> friends = new HashSet<>();
        Set<People> nowFriends = new HashSet<>();

        public People(int number) {
            this.number = number;
        }
    }

    public static int calculateDaysFriendCountByUnion(People people) {
        int friendSize = people.friends.size();

        people.friends.addAll(people.nowFriends);
        people.nowFriends.clear();

        int daysFriendCount = people.friends.size() - friendSize;
        return daysFriendCount;
    }

    public static boolean calculationDays(People[] peoples) {
        boolean isAllFreinds = true;
        int countAllDaysFriend = 0;

        for (People people : peoples) {
            countAllDaysFriend += calculateDaysFriendCountByUnion(people);

            if (people.friends.size() == peoples.length - 1) {
                continue;
            }
            isAllFreinds = false;
        }

        days++;
        countFriends.add((countAllDaysFriend / 2));

        return isAllFreinds;
    }

    public static void simulateNetwork(People[] peoples) {
        boolean flag = false;
        while (!flag) {
            for (People people : peoples) {
                for (People friends : people.friends) {
                    for (People friendsFriends : friends.friends) {
                        if (friendsFriends.number == people.number) {
                            continue;
                        }
                        people.nowFriends.add(friendsFriends);
                        friendsFriends.nowFriends.add(people);
                    }
                }
            }
            flag = calculationDays(peoples);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sizeInfo = br.readLine().split(" ");
        int size = Integer.parseInt(sizeInfo[0]);
        int edgeSize = Integer.parseInt(sizeInfo[1]);
        People[] peoples = new People[size];

        for (int i = 0; i < size; i++) {
            peoples[i] = new People(i);
        }

        for (int i = 0; i < edgeSize; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int from = Integer.parseInt(edgeInfo[0]) - 1;
            int to = Integer.parseInt(edgeInfo[1]) - 1;

            peoples[from].friends.add(peoples[to]);
            peoples[to].friends.add(peoples[from]);
        }

        simulateNetwork(peoples);

        System.out.println(days);
        for (Integer count : countFriends) {
            System.out.println(count);
        }
    }
}
