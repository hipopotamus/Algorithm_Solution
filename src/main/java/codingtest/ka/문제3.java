package codingtest.ka;

public class 문제3 {

    public int[] getUserResult(int[] discount, int[] emoticons, int[] user) {

        int[] userResult = new int[2];
        int totalPrice = 0;

        int userDiscountRate = user[0];
        int userMaxPrice = user[1];
        for (int i = 0; i < emoticons.length; i++) {

            if (discount[i] < userDiscountRate) {
                continue;
            }

            int discountedEmoticon = (int) (emoticons[i] * (1 - discount[i] / 100f));
            totalPrice += discountedEmoticon;
        }

        if (totalPrice >= userMaxPrice) {
            userResult[0] = 1;
            userResult[1] = 0;
            return userResult;
        }

        userResult[0] = 0;
        userResult[1] = totalPrice;
        return userResult;
    }

    public int[] getResult(int[] discount, int[] emoticons, int[][] users) {

        int[] result = new int[2];

        for (int i = 0; i < users.length; i++) {
            int[] user = users[i];
            int[] userResult = getUserResult(discount, emoticons, user);

            result[0] += userResult[0];
            result[1] += userResult[1];
        }

        return result;
    }

    public void dfs(int[] discount, int[] emoticons, int[][] users, int[] result, int depth) {
        if (depth == discount.length) {
            int[] tempResult = getResult(discount, emoticons, users);

            if (result[0] < tempResult[0]) {
                result[0] = tempResult[0];
                result[1] = tempResult[1];
            } else if (result[0] == tempResult[0] && result[1] < tempResult[1]) {
                result[1] = tempResult[1];
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            discount[depth] = i * 10;
            dfs(discount, emoticons, users, result, depth + 1);
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] result = new int[2];
        int[] discount = new int[emoticons.length];

        dfs(discount, emoticons, users, result, 0);

        return result;
    }
}
