package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class 임시_반장_정하기_1268 {

    public static class Student {
        int number;
        Set<Integer> friendSet = new HashSet<>();

        public Student(int number) {
            this.number = number;
        }
    }

    public static void findFriends(int[][] classArr, Student[] students) {
        for (int i = 0; i < classArr[0].length; i++) {
            for (int j = 0; j < classArr.length; j++) {
                Student student = students[j];
                int classNumber = classArr[j][i];
                for (int k = j + 1; k < classArr.length; k++) {
                    if (classNumber == classArr[k][i]) {
                        student.friendSet.add(k + 1);
                        students[k].friendSet.add(j + 1);
                    }
                }
            }
        }
    }

    public static int getClassPresident(Student[] students) {
        int max = Arrays.stream(students)
                .mapToInt(s1 -> s1.friendSet.size())
                .max().getAsInt();

        PriorityQueue<Integer> candidatePresident = Arrays.stream(students)
                .filter(s1 -> s1.friendSet.size() == max)
                .map(student -> student.number)
                .collect(Collectors.toCollection(PriorityQueue::new));

        return candidatePresident.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] classArr = new int[size][5];
        Student[] students = new Student[size];

        for (int i = 0; i < size; i++) {
            students[i] = new Student(i + 1);
        }
        
        for (int i = 0; i < size; i++) {
            String[] studentClass = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                classArr[i][j] = Integer.parseInt(studentClass[j]);
            }
        }

        findFriends(classArr, students);
        int president = getClassPresident(students);

        System.out.println(president);

    }
}
