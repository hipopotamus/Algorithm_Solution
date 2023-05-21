package df;

public class 카드기대값 {
    public long calculateE(int price, double rate, int n) {

        long totalPrice = 0;

        for (int i = 0; i < n; i++) {
            long tempPrice = price;
            while (Math.random() > rate) {
                tempPrice += price;
            }
            totalPrice += tempPrice;
        }

        return totalPrice / n;
    }
}
