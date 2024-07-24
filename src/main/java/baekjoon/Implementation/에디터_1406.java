package baekjoon.Implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 에디터_1406 {

    public static class Glyph {
        Character character;
        Glyph leftChar;
        Glyph rightChar;

        public Glyph(Character character) {
            this.character = character;
        }

        public void L() {
            if (this.leftChar.character.equals(' ')) {
                return;
            }
            this.rightChar = this.leftChar;
            this.leftChar = this.leftChar.leftChar;
        }

        public void D() {
            if (this.rightChar.character.equals(' ')) {
                return;
            }
            this.leftChar = this.rightChar;
            this.rightChar = this.rightChar.rightChar;
        }

        public void P(Glyph newChar) {
            this.leftChar.rightChar = newChar;
            this.rightChar.leftChar = newChar;

            this.leftChar = newChar;
        }

        public void B() {
            if (this.leftChar.character.equals(' ')) {
                return;
            }

            this.leftChar.leftChar.rightChar = this.rightChar;
            this.leftChar = this.leftChar.leftChar;
            this.rightChar.leftChar = this.leftChar;
        }

        public void implementationCursor(Glyph cursor) {
            this.leftChar = cursor.leftChar;
            this.rightChar = cursor.rightChar;
        }
    }

    public static void edit(String command, Character character, Glyph cursor) {
        switch (command) {
            case "L":
                cursor.L();
                return;
            case "D":
                cursor.D();
                return;
            case "P":
                Glyph newChar = new Glyph(character);
                newChar.implementationCursor(cursor);

                cursor.P(newChar);
                return;
            case "B":
                cursor.B();
        }
    }

    private static void printWord(Glyph cursor, StringBuilder sb) {
        Glyph leftchar = cursor.leftChar;
        Glyph rightchar = cursor.rightChar;

        StringBuilder leftPart = new StringBuilder();

        while (!leftchar.character.equals(' ')) {
            leftPart.append(leftchar.character);
            leftchar = leftchar.leftChar;
        }

        sb.append(leftPart.reverse());

        while (!rightchar.character.equals(' ')) {
            sb.append(rightchar.character);
            rightchar = rightchar.rightChar;
        }
    }

    private static void initCharList(String string, List<Glyph> charList) {
        for (int i = 0; i < string.length(); i++) {
            Glyph newChar = new Glyph(string.charAt(i));
            charList.add(newChar);
        }

        for (int i = 0; i < string.length(); i++) {
            Glyph newChar = charList.get(i);

            if (i == 0) {
                newChar.leftChar = new Glyph(' ');
            } else {
                newChar.leftChar = charList.get(i - 1);
            }

            if (i == string.length() - 1) {
                newChar.rightChar = new Glyph(' ');
            } else {
                newChar.rightChar = charList.get(i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        List<Glyph> charList = new ArrayList<>();
        StringTokenizer st;

        String string = br.readLine();
        int size = Integer.parseInt(br.readLine());

        initCharList(string, charList);

        Glyph cursor = new Glyph(' ');
        cursor.leftChar = charList.get(charList.size() - 1);
        cursor.rightChar = new Glyph(' ');

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("P")) {
                Character character = st.nextToken().charAt(0);
                edit(command, character, cursor);
            } else {
                edit(command, ' ', cursor);
            }
        }

        printWord(cursor, sb);

        bw.write(sb.toString());
        bw.flush();
    }
}
