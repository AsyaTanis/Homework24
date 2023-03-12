import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1() {
        System.out.println("Задача 1");
        Predicate<Integer > positiveNumber = new Predicate<Integer>() {

            @Override
            public boolean test(Integer x) {
                if(x > 0) return  true;
                else return false;
            }
        };
        Predicate<Integer> positiveNumber2 = x -> x > 1;

        System.out.println(positiveNumber.test(90));
        System.out.println(positiveNumber.test(-31));
        System.out.println(positiveNumber2.test(66));
        System.out.println(positiveNumber2.test(-66));
    }

    public static void task2() {
        System.out.println();
        System.out.println("Задача 2");
        Person person1 = new Person("Иванов Иван Иванович");
        Person person2 = new Person("Сидоров Сергей Петрович");


        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);

        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
             public void accept(Person person) {
               System.out.println("Добро пожаловать, " + person.getName() + "!");
             }
        };
        Consumer<Person> consumer2 = (Person person) -> {
            System.out.println("Добро пожаловать, " + person.getName() + "!");
        };
        consumer.accept(person1);
        consumer2.accept(person2);

      /*  for (Person person : people) {
            consumer.accept(person);
        }*/
    }

    public static void task3() {
        System.out.println();
        System.out.println("Задача 3");

        Double doubleNumber1 = new Double(3.4d);
        Double doubleNumber2 = new Double(17.7d);


        List<Double> list = new ArrayList<>();
        list.add(doubleNumber1);
        list.add(doubleNumber2);


        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double doubleNumber) {
                return (long) doubleNumber.getNum();
            }
        };

        Function<Double, Long> function1 = doubleNumber -> {
            return (long) doubleNumber.getNum();
        };
        System.out.println(function1.apply(doubleNumber1));
        System.out.println(function.apply(doubleNumber2));
    }

    public static void task4() {
        System.out.println();
        System.out.println("Задача 4");
        Supplier<Integer> randomNumber = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                int num = random.nextInt(100);
                return num;
            }
        };

        Supplier<Integer> randomNumber1 = () -> {
            Random random = new Random();
            int num = random.nextInt(100);
            return num;
        };
        System.out.println(randomNumber1.get());
    }

    public static void task5() {
        System.out.println();
        System.out.println("Задача №5");
        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer < 0) {
                    return false;
                }
                return true;
            }
        };
        Function<Integer, Integer> function3 = x -> Math.round(x);
        Function<Integer, Integer> function4 = x -> Math.subtractExact(x, 2);
        System.out.println(ternaryOperator(predicate1, function3, function4).apply(9));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}