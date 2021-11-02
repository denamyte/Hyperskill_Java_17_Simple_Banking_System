package banking.utils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collector;

public class Utils {

    private static final Random rnd = new Random();
    private static final String CARD_PREFIX = "400000";
    private static final Map<Boolean, IntUnaryOperator> IS_EVEN_LUHN_PROCESS_MAP = Map.of(
            false, value -> value * 2 - (value > 4 ? 9 : 0),
            true, value -> value
    );

    private static int randomDigit() {
        return rnd.nextInt(10);
    }

    public static String createCardNumber() {
        List<Integer> digits = new LinkedList<>(Arrays.asList(4, 0, 0, 0, 0, 0));
        appendRandomDigits(digits, 9);
        digits.add(generateLuhnChecksum(digits));
        return digitsToString(digits);
    }

    public static String createPin() {
        List<Integer> digits = new ArrayList<>(4);
        appendRandomDigits(digits, 4);
        return digitsToString(digits);
    }

    private static void appendRandomDigits(List<Integer> digits, int count) {
        for (int i = 0; i < count; i++) {
            digits.add(randomDigit());
        }
    }

    private static String digitsToString(List<Integer> digits) {
        return digits.stream()
                .collect(Collector.of(StringBuilder::new, StringBuilder::append, (sb1, sb2) -> sb1))
                .toString();
    }

    private static int generateLuhnChecksum(List<Integer> digits) {
        AtomicInteger counter = new AtomicInteger();
        final int sum = digits.stream()
                .mapToInt(value -> value)
                .map(value -> IS_EVEN_LUHN_PROCESS_MAP.get(counter.incrementAndGet() % 2 == 0).applyAsInt(value))
                .sum();
        int remainder = sum % 10;
        return remainder == 0 ? 0 : 10 - remainder;
    }
}
