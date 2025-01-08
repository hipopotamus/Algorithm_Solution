package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비트_문자열_재배열하기_10330 {

    public static int[] getRegenerateBit(int zeroCount, int oneCount, int[] codes) {
        int size = zeroCount + oneCount;
        int[] reGenerateBit = new int[size];

        int tempCount = 0;
        int startBit = 0;
        for (int i = 0; i < codes.length; i += 2) {
            tempCount += codes[i];
        }

        if (tempCount != zeroCount) {
            startBit = 1;
        }

        int bitIndex = 0;
        for (int i = 0; i < codes.length; i ++) {
            for (int j = bitIndex; j < bitIndex + codes[i]; j++) {
                reGenerateBit[j] = startBit;
            }
            bitIndex += codes[i];
            startBit = (startBit + 1) % 2;
        }

        return reGenerateBit;
    }

    public static int[] inverseBit(int[] reGenerateBit) {
        int[] inverseBit = new int[reGenerateBit.length];

        for (int i = 0; i < reGenerateBit.length; i++) {
            inverseBit[i] = (reGenerateBit[i] + 1) % 2;
        }

        return inverseBit;
    }

    public static int getRegenerateCount(int[] bit, int[] reGenerateBit) {
        int bitIndex = bit.length - 1;
        int reGenerateIndex = reGenerateBit.length - 1;
        int count = 0;

        while (bitIndex >= 0 && reGenerateIndex >= 0) {
            while (bitIndex > 0 && bit[bitIndex] != 1) {
                bitIndex--;
            }
            while (reGenerateIndex > 0 && reGenerateBit[reGenerateIndex] != 1) {
                reGenerateIndex--;
            }

            count += Math.abs(bitIndex - reGenerateIndex);
            bitIndex--;
            reGenerateIndex--;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInfo = br.readLine().split(" ");
        int bitSize = Integer.parseInt(sizeInfo[0]);
        int codeSize = Integer.parseInt(sizeInfo[1]);
        int[] bit = new int[bitSize];
        int[] codes = new int[codeSize];
        int zeroCount = 0;
        int oneCount = 0;

        String[] bitInfo = br.readLine().split(" ");
        for (int i = 0; i < bitSize; i++) {
            int number = Integer.parseInt(bitInfo[i]);
            if (number == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
            bit[i] = number;
        }

        String[] codeInfo = br.readLine().split(" ");
        for (int i = 0; i < codeSize; i++) {
            int number = Integer.parseInt(codeInfo[i]);
            codes[i] = number;
        }

        int[] regenerateBit = getRegenerateBit(zeroCount, oneCount, codes);
        int regenerateCount = getRegenerateCount(bit, regenerateBit);

        if (zeroCount == oneCount) {
            int[] inverseBit = inverseBit(regenerateBit);

            regenerateCount = Math.min(getRegenerateCount(bit, inverseBit), regenerateCount);
        }

        System.out.println(regenerateCount);
    }
}
