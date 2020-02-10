public class StringCalculator {

    public static int splitAndSum(String text) {
        if (isBlank(text)) return 0;
        return sum(toPositives(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static Positive[] toPositives(String[] values) {
        Positive[] numbers = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = new Positive(values[i]);
        }
        return numbers;
    }

    private static int[] toInts(String[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = toInt(values[i]);
        }
        return result;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) throw new RuntimeException();
        return number;
    }

    private static int sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            result = result.add(number);
        }
        return result.getNumber();

    }


}