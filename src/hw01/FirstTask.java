package taskOne;

public class FirstTask {
    public static void main(String[] args) {

//        Первая часть задания - тернарный оператор
        long start = 500L, end = 800L, between;
        between = start < end ? end - start : -1;
        System.out.println(between);

//        Вторая часть задания - сумма цифр двухзначного числа
        int inputTwo = 63;
        System.out.println(inputTwo / 10 + inputTwo % 10);

//        Третья часть задания - сумма цифр трехзначного числа
        int inputThree = 974;
        System.out.println(inputThree / 100 + inputThree / 10 % 10 + inputThree % 10);

    }
}
