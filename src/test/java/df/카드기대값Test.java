package df;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 카드기대값Test {

    @Test
    public void 카드기대값() {
        카드기대값 test = new 카드기대값();
        int price = 250;
        double rate = 0.8;
        int n = 1000000;

        long one = test.calculateE(250, 0.4, n);
        long two = test.calculateE(500, 0.8, n);
        System.out.println(one);
        System.out.println(two);

    }

}