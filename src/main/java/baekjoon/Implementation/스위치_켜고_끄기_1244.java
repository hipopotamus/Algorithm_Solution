package baekjoon.Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class 스위치_켜고_끄기_1244 {

    public static class Switch {
        int status;

        public Switch(int status) {
            this.status = status;
        }

        public void toggle() {
            this.status = (status + 1) % 2;
        }
    }

    public static void manSwitch(int number, Switch[] switches) {
        for (int i = number; i < switches.length; i += number + 1) {
            switches[i].toggle();
        }
    }

    public static void womanSwitch(int number, Switch[] switches) {
        switches[number].toggle();
        for (int i = 1; (number - i >= 0 && number + i < switches.length); i++) {
            if (switches[number - i].status != switches[number + i].status) {
                break;
            }
            switches[number - i].toggle();
            switches[number + i].toggle();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;


        int switchSize = Integer.parseInt(br.readLine());
        Switch[] switches = new Switch[switchSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switchSize; i++) {
            switches[i] = new Switch(Integer.parseInt(st.nextToken()));
        }

        int peopleSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < peopleSize; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken()) - 1;

            if (gender == 1) {
                manSwitch(number, switches);
            } else if (gender == 2) {
                womanSwitch(number, switches);
            }
        }

        for (int i = 0; i < switchSize; i++) {
            sb.append(switches[i].status).append(' ');
            count++;
            if (count % 20 == 0) {
                sb.append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
