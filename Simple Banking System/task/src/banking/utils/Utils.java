package banking.utils;

import java.util.Random;

public class Utils {

    private static final Random rnd = new Random();
    public static final String CARD_PREFIX = "400000";

    private static int randomDigit() {
        return rnd.nextInt(10);
    }

    private static void appendDigits(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(randomDigit());
        }
    }

    public static String createCardNumber() {
        StringBuilder sb = new StringBuilder(CARD_PREFIX);
        appendDigits(sb, 9);
        // TODO: 10/4/21 When the Luhn algorithm is ready, call it, instead of appending 0
        sb.append(0);
        return sb.toString();
    }

    public static String createPin() {
        StringBuilder sb = new StringBuilder();
        appendDigits(sb, 4);
        return sb.toString();
    }
}
