package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Σ_13172 {

    public static int calculateExpectedValueMod(Map<Integer, Integer> fractionPairs) {
        BigInteger result = BigInteger.ZERO;
        BigInteger mod = BigInteger.valueOf(1000000007);

        for (Map.Entry<Integer, Integer> entry : fractionPairs.entrySet()) {
            BigInteger denominator = BigInteger.valueOf(entry.getKey());
            BigInteger numerator = BigInteger.valueOf(entry.getValue());

            BigInteger modularInverse = numerator.modPow(mod.subtract(BigInteger.TWO), mod);

            result = result.add(denominator.multiply(modularInverse).mod(mod));
        }

        return result.mod(mod).intValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            Integer denominator = Integer.parseInt(st.nextToken());
            Integer numerator = Integer.parseInt(st.nextToken());

            map.put(numerator, denominator);
        }

        int expectedValueMod = calculateExpectedValueMod(map);

        System.out.println(expectedValueMod);
    }
}
