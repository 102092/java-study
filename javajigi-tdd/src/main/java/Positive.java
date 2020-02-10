public class Positive {
    private int number;

    public Positive(int number) {
        this.number = number;
    }

    public Positive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) throw new RuntimeException();
        this.number = number;
    }

    public Positive add(Positive other) {
        return new Positive(this.number + other.number);
    }

    public int getNumber() {
        return number;
    }
}
