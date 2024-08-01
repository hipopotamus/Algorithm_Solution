package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 임시_반장_정하기_1268 {

    public static class Student {
        int number;
        Set<Integer> friendSet = new HashSet<>();

        public Student(int number) {
            this.number = number;
        }
    }

    //같은 반이였던 사람들을 찾는 메서드
    //각 학년별로 순서대로 학생들을 전부 조사한다.
    public static void findFriends(int[][] classArr, Student[] students) {
        for (int col = 0; col < classArr[0].length; col++) {
            for (int row = 0; row < classArr.length; row++) {
                Student student = students[row];
                int classNumber = classArr[row][col];
                for (int k = row + 1; k < classArr.length; k++) {
                    if (classNumber == classArr[k][col]) {
                        student.friendSet.add(k + 1);
                        students[k].friendSet.add(row + 1);
                    }
                }
            }
        }
    }

    //같은 반이였던 사람이 가장많은 학생을 뽑는 메서드
    public static int getClassPresident(Student[] students) {
        Arrays.sort(students, (s1, s2) -> Integer.compare(s2.friendSet.size(), s1.friendSet.size()));
        return students[0].number;
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
