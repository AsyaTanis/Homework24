import java.util.Objects;
public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Положительное число: " + number;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number numbers = (Number) o;
        return number == numbers.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}